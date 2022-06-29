package net.guides.springboot2.springboot2jpacrudexample.service.Stock;

import net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type.Detail_Produit_Json;
import net.guides.springboot2.springboot2jpacrudexample.controller.Stock.type.Detail_Stock_Local;
import net.guides.springboot2.springboot2jpacrudexample.model.Stock.Stock;
import net.guides.springboot2.springboot2jpacrudexample.repository.Stock.Stock_Repositrory;
import net.guides.springboot2.springboot2jpacrudexample.service.MyFileNotFoundException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Stock_Service {

    @Autowired
    Stock_Repositrory Repo;

    @Autowired
    DataSource dataSource;
    public List<Stock> Stocks() {
        return (List<Stock>)  Repo.findAll();
    }
    public Optional<Stock> Stock (Long id) {
        return   Repo.findById(id);
    }

    public Stock Ajouter ( Long id_Produit, String ref_Fr, int quantite, Double Ancien_Prix, Double prix, String type_Detail, byte[] details ) {
        Stock dbFile = new Stock(  id_Produit,   ref_Fr,   quantite,   Ancien_Prix,   prix,   type_Detail,   details);
        return Repo.save(dbFile);
    }

   /* public void Entree_Stock (String nom , MultipartFile details) {
        Statement stmt = null;
        Connection cnx =null;
        try {
             cnx = dataSource.getConnection() ;
             stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Stock> listeStock = new ArrayList<>();
         try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = null;
            try {
               document = saxBuilder.build(details.getInputStream());
            } catch (JDOMException e) {
                e.printStackTrace();
            }
            Element root = document.getRootElement();
            Namespace ns = root.getNamespace();
            Element DataSets = document.getRootElement();
            List<Element> be = DataSets.getChildren();
            for (Element clt : be) {
                List<Element> tab = clt.getChildren();
                Stock s = new Stock();
                s.setId_Produit(Long.valueOf(tab.get(0).getValue()));
                s.setQuantite(Integer.parseInt(tab.get(2).getValue()));
                s.setRef_Fr(tab.get(1).getValue());

                listeStock.add(s);
            }

            for(int j = 0 ; j<listeStock.size(); j++)
            {
                  int qt1 =  0 ;
                  int qt2 = 0 ;
                  try {
                     String query = " SELECT  Quantite , "+nom+" FROM Stock  WHERE  id_produit = "+listeStock.get(j).getId_Produit()+" ";
                     ResultSet rs = stmt.executeQuery(query);
                      while (rs.next()) {
                         qt1 =rs.getInt(1) ;
                         qt2= rs.getInt(2) ;
                     }
                    qt1=qt1+listeStock.get(j).getQuantite();
                    qt2=qt2+listeStock.get(j).getQuantite();
                    String sql = "UPDATE stock SET "+nom+" = "+qt2+" , Quantite = "+qt1+" WHERE  id_produit = "+listeStock.get(j).getId_Produit()+" ";
                    stmt.executeUpdate(sql );
                 } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
             try {
                 stmt.close();
                 cnx.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void Ajouter_importation ( Element Produits  )
    {
        Statement stmt = null;
        Connection cnx =null;

        try {
            cnx = dataSource.getConnection() ;
            stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Element> ListeProduits = Produits.getChildren();

        Element  ListeProduit_simple = Produits.getChild("Produits_Simples");
        Element  ListeProduits_Series = Produits.getChild("Produits_Series");
        Element  ListeProduits_4Gs = Produits.getChild("Produits_4Gs");

        String Local = Produits.getAttributeValue("Local") ;
        String fr = Produits.getAttributeValue("Fournisseur") ;

        if(ListeProduit_simple!=null)
        {
            for (Element Produit : ListeProduit_simple.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + pmp +" , Ancien_Prix = " + Prix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        if(ListeProduits_Series!=null) {
            for (Element Produit : ListeProduits_Series.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;

                            for (Element N_Serie : Produit.getChild("N_Series").getChildren()) {

                                Element n_s  = new Element("N_Serie");
                                Element num = new Element("Numero");  num.setText(N_Serie.getValue());
                                Element src = new Element("Fornisseur"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Entree");
                                // n_s.setName( N_Serie.getValue());
                                n_s.addContent(num);n_s.addContent(src);n_s.addContent(Loc);
                                RacineProduit.addContent(n_s) ;
                            }


                            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                            ByteArrayOutputStream bout = new ByteArrayOutputStream();
                            try {
                                sortie.output(document, bout);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bout.toByteArray();
                            s.setDetails(bout.toByteArray());
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix +   " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        Element RacineProduit = new Element ("Produits");
                        for (Element N_Serie : Produit.getChild("N_Series").getChildren()) {

                            Element n_s  = new Element("N_Serie");
                            Element num = new Element("Numero");  num.setText(N_Serie.getValue());
                            Element src = new Element("Fornisseur"); src.setText(fr);
                            Element Loc = new Element("Local");Loc.setText(Local);
                            Loc.setAttribute("Operation", "Entree");
                            n_s.addContent(num);n_s.addContent(src);n_s.addContent(Loc);
                            RacineProduit.addContent(n_s) ;
                        }
                        Document document = new Document(RacineProduit);
                        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        try {
                            sortie.output(document, bout);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        bout.toByteArray();
                        s.setDetails(bout.toByteArray());
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        if(ListeProduits_4Gs!=null) {
            for (Element Produit : ListeProduits_4Gs.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;

                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;


                            for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {

                                Element n_s  = new Element("Produit_4G");
                                Element num = new Element("N_Serie");  num.setText(Produit_4g.getChild("N_Serie").getValue());
                                Element src = new Element("Fornisseur"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Entree");
                                Element E1 = new Element("E1");E1.setText(Produit_4g.getChild("E1").getValue());
                                Element E2 = new Element("E2");E2.setText(Produit_4g.getChild("E2").getValue());
                                //    n_s.setName(Produit_4g.getChild("N_Serie").getValue());
                                n_s.addContent(num);;n_s.addContent(E1);;n_s.addContent(E2);n_s.addContent(src);n_s.addContent(Loc);
                                RacineProduit.addContent(n_s) ;
                            }
                            try {
                                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                                ByteArrayOutputStream bout = new ByteArrayOutputStream();

                                sortie.output(document, bout);
                                bout.toByteArray();
                                s.setDetails(bout.toByteArray());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix +   " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_Revient_U").getValue()));
                        Element RacineProduit = new Element ("Produits");

                        for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {

                            Element n_s  = new Element("Produit_4G");
                            Element num = new Element("N_Serie");  num.setText(Produit_4g.getChild("N_Serie").getValue());
                            Element src = new Element("Fornisseur"); src.setText(fr);
                            Element Loc = new Element("Local");Loc.setText(Local);
                            Loc.setAttribute("Operation", "Entree");
                            Element E1 = new Element("E1");E1.setText(Produit_4g.getChild("E1").getValue());
                            Element E2 = new Element("E2");E2.setText(Produit_4g.getChild("E2").getValue());
                            // n_s.setName(Produit_4g.getChild("N_Serie").getValue());
                            n_s.addContent(num); n_s.addContent(E1); n_s.addContent(E2);n_s.addContent(src);n_s.addContent(Loc);
                            RacineProduit.addContent(n_s) ;
                        }
                        Document document = new Document(RacineProduit);
                        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        try {
                            sortie.output(document, bout);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        bout.toByteArray();
                        s.setDetails(bout.toByteArray());
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }

    public void Ajouter ( Element Produits  )
    {
        Statement stmt = null;
        Connection cnx =null;

        try {
            cnx = dataSource.getConnection() ;
            stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Element> ListeProduits = Produits.getChildren();

        Element  ListeProduit_simple = Produits.getChild("Produits_Simples");
        Element  ListeProduits_Series = Produits.getChild("Produits_Series");
        Element  ListeProduits_4Gs = Produits.getChild("Produits_4Gs");

        String Local = Produits.getAttributeValue("Local") ;
        String fr = Produits.getAttributeValue("Fournisseur") ;

        if(ListeProduit_simple!=null)
        {
            for (Element Produit : ListeProduit_simple.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_U_HT").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                             ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + pmp +" , Ancien_Prix = " + Prix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        if(ListeProduits_Series!=null) {
            for (Element Produit : ListeProduits_Series.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_U_HT").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;

                            for (Element N_Serie : Produit.getChild("N_Series").getChildren()) {

                                Element n_s  = new Element("N_Serie");
                                Element num = new Element("Numero");  num.setText(N_Serie.getValue());
                                Element src = new Element("Fornisseur"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Entree");
                               // n_s.setName( N_Serie.getValue());
                                n_s.addContent(num);n_s.addContent(src);n_s.addContent(Loc);
                                RacineProduit.addContent(n_s) ;
                            }


                            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                            ByteArrayOutputStream bout = new ByteArrayOutputStream();
                            try {
                                sortie.output(document, bout);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bout.toByteArray();
                            s.setDetails(bout.toByteArray());
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix +   " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        Element RacineProduit = new Element ("Produits");
                        for (Element N_Serie : Produit.getChild("N_Series").getChildren()) {

                            Element n_s  = new Element("N_Serie");
                            Element num = new Element("Numero");  num.setText(N_Serie.getValue());
                            Element src = new Element("Fornisseur"); src.setText(fr);
                            Element Loc = new Element("Local");Loc.setText(Local);
                            Loc.setAttribute("Operation", "Entree");
                            n_s.addContent(num);n_s.addContent(src);n_s.addContent(Loc);
                            RacineProduit.addContent(n_s) ;
                        }
                        Document document = new Document(RacineProduit);
                        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        try {
                            sortie.output(document, bout);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        bout.toByteArray();
                        s.setDetails(bout.toByteArray());
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        if(ListeProduits_4Gs!=null) {
            for (Element Produit : ListeProduits_4Gs.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    double nprix = Double.parseDouble(Produit.getChild("Prix_U_HT").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;

                                Ancien_Prix=rs.getDouble(3);
                                Prix = rs.getDouble(4);
                            }
                            pmp = ((qt1 * Prix)+(nqt*nprix))/(qt1 + nqt);
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;


                            for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {

                                Element n_s  = new Element("Produit_4G");
                                Element num = new Element("N_Serie");  num.setText(Produit_4g.getChild("N_Serie").getValue());
                                Element src = new Element("Fornisseur"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Entree");
                                Element E1 = new Element("E1");E1.setText(Produit_4g.getChild("E1").getValue());
                                Element E2 = new Element("E2");E2.setText(Produit_4g.getChild("E2").getValue());
                            //    n_s.setName(Produit_4g.getChild("N_Serie").getValue());
                                n_s.addContent(num);;n_s.addContent(E1);;n_s.addContent(E2);n_s.addContent(src);n_s.addContent(Loc);
                                RacineProduit.addContent(n_s) ;
                            }
                            try {
                            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                            ByteArrayOutputStream bout = new ByteArrayOutputStream();

                                sortie.output(document, bout);
                                bout.toByteArray();
                                s.setDetails(bout.toByteArray());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix +   " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        s = new Stock();
                        s.setId_Produit(Long.valueOf(Produit.getChild("Id").getValue()));
                        s.setQuantite(Integer.parseInt(Produit.getChild("Qte").getValue()));
                        s.setRef_Fr(Produit.getChild("Ref").getValue());
                        s.setAncien_Prix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        s.setPrix(Double.parseDouble(Produit.getChild("Prix_U_HT").getValue()));
                        Element RacineProduit = new Element ("Produits");

                        for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {

                            Element n_s  = new Element("Produit_4G");
                            Element num = new Element("N_Serie");  num.setText(Produit_4g.getChild("N_Serie").getValue());
                            Element src = new Element("Fornisseur"); src.setText(fr);
                            Element Loc = new Element("Local");Loc.setText(Local);
                            Loc.setAttribute("Operation", "Entree");
                            Element E1 = new Element("E1");E1.setText(Produit_4g.getChild("E1").getValue());
                            Element E2 = new Element("E2");E2.setText(Produit_4g.getChild("E2").getValue());
                           // n_s.setName(Produit_4g.getChild("N_Serie").getValue());
                            n_s.addContent(num); n_s.addContent(E1); n_s.addContent(E2);n_s.addContent(src);n_s.addContent(Loc);
                            RacineProduit.addContent(n_s) ;
                        }
                        Document document = new Document(RacineProduit);
                        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                        ByteArrayOutputStream bout = new ByteArrayOutputStream();
                        try {
                            sortie.output(document, bout);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        bout.toByteArray();
                        s.setDetails(bout.toByteArray());
                        Repo.save(s);
                        String sql = "UPDATE stock SET "+Local+" = "+nqt+" , Quantite = "+nqt+ " ,Prix = " + nprix +" , Ancien_Prix = " + nprix + " WHERE  id_produit = "+s.getId_Produit()+" ";
                        stmt.executeUpdate(sql );
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }

    public void Abondoner ( Element Produits  )
    {
        Statement stmt = null;
        Connection cnx =null;

        try {
            cnx = dataSource.getConnection() ;
            stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Element> ListeProduits = Produits.getChildren();

        Element  ListeProduit_simple = Produits.getChild("Produits_Simples");
        Element  ListeProduits_Series = Produits.getChild("Produits_Series");
        Element  ListeProduits_4Gs = Produits.getChild("Produits_4Gs");

        String Local = Produits.getAttributeValue("Local") ;
        String fr = Produits.getAttributeValue("Client") ;

        if(ListeProduit_simple!=null)
        {
            for (Element Produit : ListeProduit_simple.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                   // double nprix = Double.parseDouble(Produit.getChild("Prix_U_HT").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                            }
                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ "   WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        if(ListeProduits_Series!=null) {
            for (Element Produit : ListeProduits_Series.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());

                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;

                            }

                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;

                            for (Element N_Serie : Produit.getChild("N_Series").getChildren()) {

                                Element n_s  = new Element("N_Serie");
                                Element num = new Element("Numero");  num.setText(N_Serie.getValue());
                                Element src = new Element("Fournisseur"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Abondonner");
                                // n_s.setName( N_Serie.getValue());
                                n_s.addContent(num);n_s.addContent(src);n_s.addContent(Loc);
                                System.out.println(n_s);
                                RacineProduit.addContent(n_s) ;
                            }


                            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                            ByteArrayOutputStream bout = new ByteArrayOutputStream();
                            try {
                                sortie.output(document, bout);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            bout.toByteArray();
                            s.setDetails(bout.toByteArray());
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ " WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        if(ListeProduits_4Gs!=null) {
            for (Element Produit : ListeProduits_4Gs.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                //    double nprix = Double.parseDouble(Produit.getChild("Prix_U_HT").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0; double Ancien_Prix = 0 ;  double Prix = 0 ; double pmp ;
                            String query = " SELECT  Quantite , "+Local+" , Ancien_Prix, Prix FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;


                            }

                            qt1= qt1 + nqt;
                            qt2= qt2 + nqt;


                            for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {

                                Element n_s  = new Element("Produit_4G");
                                Element num = new Element("N_Serie");  num.setText(Produit_4g.getChild("N_Serie").getValue());
                                Element src = new Element("Client"); src.setText(fr);
                                Element Loc = new Element("Local");Loc.setText(Local);
                                Loc.setAttribute("Operation", "Entree");
                                Element E1 = new Element("E1");E1.setText(Produit_4g.getChild("E1").getValue());
                                Element E2 = new Element("E2");E2.setText(Produit_4g.getChild("E2").getValue());
                                //    n_s.setName(Produit_4g.getChild("N_Serie").getValue());
                                n_s.addContent(num);;n_s.addContent(E1);;n_s.addContent(E2);n_s.addContent(src);n_s.addContent(Loc);
                                RacineProduit.addContent(n_s) ;
                            }
                            try {
                                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                                ByteArrayOutputStream bout = new ByteArrayOutputStream();

                                sortie.output(document, bout);
                                bout.toByteArray();
                                s.setDetails(bout.toByteArray());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Repo.save(s);
                            String sql = "UPDATE stock SET "+Local+" = "+qt2+" , Quantite = "+qt1+ "  WHERE  id_produit = "+s.getId_Produit()+" ";
                            stmt.executeUpdate(sql );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }

    public void Supprimer ( Element Produits  )
    {
        Statement stmt = null;
        Connection cnx =null;

        try {
            cnx = dataSource.getConnection() ;
            stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Element> ListeProduits = Produits.getChildren();

        Element  ListeProduit_simple = Produits.getChild("Produits_Simples");
        Element  ListeProduits_Series = Produits.getChild("Produits_Series");
        Element  ListeProduits_4Gs = Produits.getChild("Produits_4Gs");

        String Local = Produits.getAttributeValue("Local") ;
       // String fr = Produits.getAttributeValue("Client") ;

        if(ListeProduit_simple!=null)
        {
            for (Element Produit : ListeProduit_simple.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            int qt1 = 0 ; int qt2 = 0;
                            String query = " SELECT  Quantite , "+Local+"  FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                            }
                            if(qt1>0) {
                                qt1 = qt1 - nqt;
                                qt2 = qt2 - nqt;
                                String sql = "UPDATE stock SET " + Local + " = " + qt2 + " , Quantite = " + qt1 + " WHERE  id_produit = " + s.getId_Produit() + " ";
                                stmt.executeUpdate(sql);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        if(ListeProduits_Series!=null) {
            for (Element Produit : ListeProduits_Series.getChildren()) {
                try {
                    cnx = dataSource.getConnection() ;
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity =  Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s ;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());

                    if (searchEntity.isPresent()) {
                        s=searchEntity.get() ;
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;

                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit =document.getRootElement();

                            } catch ( Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0 ; int qt2 = 0;

                            String query = " SELECT  Quantite , "+Local+"  FROM Stock  WHERE  id_produit = "+s.getId_Produit()+" ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 =rs.getInt(1) ;
                                qt2= rs.getInt(2) ;
                            }
                            if(qt1>0) {

                                qt1 = qt1 - nqt;
                                qt2 = qt2 - nqt;
                                Element sup = null;int test = 0 ;
                                for (Element Produit_Serie : Produit.getChild("N_Series").getChildren()) {
                                    String n1 = Produit_Serie.getValue();

                                    for (Element elem : RacineProduit.getChildren()) {
                                        if (elem.getChild("Numero").getValue().equals(n1)) {
                                            sup=elem; test = 1;
                                        }
                                    }
                                    RacineProduit.getChildren().remove(sup);
                                }

                                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                                try {
                                    sortie.output(document, bout);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                bout.toByteArray();
                                s.setDetails(bout.toByteArray());
                                if(test==1) {

                                    Repo.save(s);
                                    String sql = "UPDATE stock SET " + Local + " = " + qt2 + " , Quantite = " + qt1 + " WHERE  id_produit = " + s.getId_Produit() + " ";
                                     stmt.executeUpdate(sql);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    stmt.close();
                    cnx.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }


        if(ListeProduits_4Gs!=null) {
            for (Element Produit : ListeProduits_4Gs.getChildren()) {
                try {
                    cnx = dataSource.getConnection();
                    stmt = cnx.createStatement();
                    Optional<Stock> searchEntity = Repo.findById(Long.valueOf(Produit.getChild("Id").getValue()));
                    Stock s;
                    int nqt = Integer.parseInt(Produit.getChild("Qte").getValue());
                    if (searchEntity.isPresent()) {
                        s = searchEntity.get();
                        try {
                            SAXBuilder saxBuilder = new SAXBuilder();
                            Document document = null;
                            Element RacineProduit = null;
                            try {
                                document = saxBuilder.build(new ByteArrayInputStream(s.getDetails()));
                                RacineProduit = document.getRootElement();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            int qt1 = 0;
                            int qt2 = 0;
                            String query = " SELECT  Quantite , " + Local + "   FROM Stock  WHERE  id_produit = " + s.getId_Produit() + " ";
                            ResultSet rs = stmt.executeQuery(query);
                            while (rs.next()) {
                                qt1 = rs.getInt(1);
                                qt2 = rs.getInt(2);
                            }

                            if (qt1 > 0) {
                                qt1 = qt1 - nqt;
                                qt2 = qt2 - nqt;
                                Element sup = null;
                                int test = 0;
                                for (Element Produit_4g : Produit.getChild("Produit_4Gs").getChildren()) {
                                    String n1 = Produit_4g.getChild("N_Serie").getValue();
                                    for (Element elem : RacineProduit.getChildren()) {
                                        if (n1.equals(elem.getChild("N_Serie").getValue())) {
                                            sup = elem;
                                            test = 1;
                                        }
                                    }
                                    RacineProduit.getChildren().remove(sup);
                                }
                                try {
                                    XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                                    ByteArrayOutputStream bout = new ByteArrayOutputStream();
                                    sortie.output(document, bout);
                                    bout.toByteArray();
                                    s.setDetails(bout.toByteArray());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (test == 1) {
                                    Repo.save(s);
                                    String sql = "UPDATE stock SET " + Local + " = " + qt2 + " , Quantite = " + qt1 + "   WHERE  id_produit = " + s.getId_Produit() + " ";
                                    stmt.executeUpdate(sql);
                                }

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }


    public void Modifier_Stock (String nom , MultipartFile details) {
        Statement stmt = null;
        Connection cnx =null;

        try {
            cnx = dataSource.getConnection() ;
            stmt = cnx.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Stock> listeStock = new ArrayList<>();
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = null;
            try {
                document = saxBuilder.build(details.getInputStream());
            } catch (JDOMException e) {
                e.printStackTrace();
            }
            Element root = document.getRootElement();
            Namespace ns = root.getNamespace();
            Element DataSets = document.getRootElement();
            List<Element> be = DataSets.getChildren();
            for (Element clt : be) {
                List<Element> tab = clt.getChildren();
                Stock s = new Stock();
                s.setId_Produit(Long.valueOf(tab.get(0).getValue()));
                s.setQuantite(Integer.parseInt(tab.get(2).getValue()));
                s.setRef_Fr(tab.get(1).getValue());

                listeStock.add(s);
            }

            for(int j = 0 ; j<listeStock.size(); j++)
            {
                int qt1 =  0 ;
                int qt2 = 0 ;
                try {
                    String query = " SELECT  Quantite , "+nom+" FROM Stock  WHERE  id_produit = "+listeStock.get(j).getId_Produit()+" ";
                    ResultSet rs = stmt.executeQuery(query);
                    while (rs.next()) {
                        qt1 =rs.getInt(1) ;
                        qt2= rs.getInt(2) ;
                    }
                    qt1=qt1+listeStock.get(j).getQuantite();
                    qt2=qt2+listeStock.get(j).getQuantite();
                    String sql = "UPDATE stock SET "+nom+" = "+qt2+" , Quantite = "+qt1+" WHERE  id_produit = "+listeStock.get(j).getId_Produit()+" ";
                    stmt.executeUpdate(sql );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            try {
                stmt.close();
                cnx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ResponseEntity<Object> Supprimer_Stock (Long id ) {
        Optional<Stock>  Entity =  Repo.findById(id );
        if (Entity.isPresent()) {
            Stock Entity_deleted = Entity.get();
              Repo.delete(Entity_deleted);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }

    public List<String> lister_champ (){

        return Repo.Lister_champs() ;
    }

    public  List<Stock>  filtre (   String champ , String valeur ) {
        List<Stock> liste = new ArrayList<>();
   /*     try {
            String query = "select Id_Local as id_Local,  Nom_Local as nom_Local, Categorie_Local as categorie_Local,  Description_Local as description_Local  from fiche_local where "+champ+" = '" + valeur + "'";
            Statement stmt = dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Fiche_Local d = new Fiche_Local();

                d.setId_Local(Long.valueOf(rs.getString("id_Local")));
                d.setNom_Local(rs.getString("nom_Local"));
                d.setCategorie_Local(rs.getString("categorie_Local"));
                d.setDescription_Local(rs.getString("description_Local"));
                liste.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        return liste ;
    }



    public Stock Detail (Long  Id) {
        return Repo.findById(Id)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " +  Id));
    }

    public String Produit_en_Stock(Long  Id) {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            return "oui";
        }
        return "non" ;
    }

    public String Ref_Produit( Long Id )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            return s.getRef_Fr();
        }
        return null ;
    }

    public double Prix_Produit (Long Id )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            return s.getPrix();
        }
        return -1 ;
    }

    public double Ancien_Prix (Long Id )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            return s.getAncien_Prix();
        }
        return -1 ;
    }


    public void Modifier_Ancien_Prix_Produit (Long Id , double prix  )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s1 = searchEntity.get();
            System.out.println(s1.getAncien_Prix());
            s1.setAncien_Prix(prix);
            System.out.println(s1.getAncien_Prix());
            Repo.save(s1);
        }

    }

    public void Modifier_Prix_Produit (Long Id , double prix  )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            s.setPrix(prix);
            Repo.save(s);
        }

    }
    public void Modifier_Valeur_Produit (Long Id , double Valeur  )
    {
        Optional<Stock> searchEntity =  Repo.findById(Id);
        if (searchEntity.isPresent()) {
            Stock s = searchEntity.get();
            s.setValeur_Produit(Valeur);
            Repo.save(s);
        }
    }

    public Integer Quantite_Produit_Par_Stock_En_Local(Long id , String local) {

        Integer nb =  0 ;
         try {
            String query =   "SELECT "+local+" FROM STOCK  WHERE id_produit = '" + id + "'" ;

             Connection cnx = dataSource.getConnection() ;
             Statement stmt = cnx.createStatement();
             ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                nb=rs.getInt(1);
            }
             stmt.close();
             cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nb ;
    }


    public ArrayList<Detail_Stock_Local> Liste_Produits_En_Local(String local) {
        String nom = local;
        ArrayList<Detail_Stock_Local> liste = new ArrayList<>();
        try {

            String query =   "SELECT id_produit , prix , quantite , "+local+" FROM STOCK  WHERE "+local+ " > '" + 0 + "'" ;
            System.out.println(query);
            Connection cnx = dataSource.getConnection() ;
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Detail_Stock_Local d =new Detail_Stock_Local();
                d.setId_Produit(rs.getLong("id_produit"));
                d.setPrix(rs.getDouble("prix"));
                d.setQte(rs.getInt("quantite"));
                d.setQte_Local(rs.getInt(""+local+""));
                d.setLocal(nom);
                liste.add(d);
             }
            stmt.close();
            cnx.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste ;
    }


}

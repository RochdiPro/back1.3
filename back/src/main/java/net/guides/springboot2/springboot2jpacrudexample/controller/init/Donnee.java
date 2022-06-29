package net.guides.springboot2.springboot2jpacrudexample.controller.init;

import net.guides.springboot2.springboot2jpacrudexample.model.Donnee.*;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Donnee {


    @RequestMapping(value = "/code" ,method = RequestMethod.POST)
    public String   code () {

        Element objets = new Element("Objets");

        Element objet_0 = new Element("Objet");
        Element objet_0_code = new Element("Code");objet_0_code.setText("0000001");
        Element objet_0_des= new Element("Description");objet_0_des.setText("TABLES_FIXES");
        Element objet_0_qt= new Element("Quantite");objet_0_qt.setText("0");
        objet_0.addContent(objet_0_code);objet_0.addContent(objet_0_des);objet_0.addContent(objet_0_qt);


        Element objet_01 = new Element("Objet");
        Element objet_01_code = new Element("Code");objet_01_code.setText("0000002");
        Element objet_01_des= new Element("Description");objet_01_des.setText("TABLE_MONOPLACE");
        Element objet_01_qt= new Element("Quantite");objet_01_qt.setText("0");
        objet_01.addContent(objet_01_code);objet_01.addContent(objet_01_des);objet_01.addContent(objet_01_qt);

        Element objet_02 = new Element("Objet");
        Element objet_02_code = new Element("Code");objet_02_code.setText("0000003");
        Element objet_02_des= new Element("Description");objet_02_des.setText("TABLE_ENFANT");
        Element objet_02_qt= new Element("Quantite");objet_02_qt.setText("0");
        objet_02.addContent(objet_02_code);objet_02.addContent(objet_02_des);objet_02.addContent(objet_02_qt);

        Element objet_1 = new Element("Objet");
        Element objet_1_code = new Element("Code");objet_1_code.setText("0000004");
        Element objet_1_des= new Element("Description");objet_1_des.setText("TABLE_CARRE");
        Element objet_1_qt= new Element("Quantite");objet_1_qt.setText("0");
        objet_1.addContent(objet_1_code);objet_1.addContent(objet_1_des);objet_1.addContent(objet_1_qt);

        Element objet_2 = new Element("Objet");
        Element objet_2_code = new Element("Code");objet_2_code.setText("0000005");
        Element objet_2_des= new Element("Description");objet_2_des.setText("TABLE_MIXAGE_BLUETOOTH");
        Element objet_2_qt= new Element("Quantite");objet_2_qt.setText("0");
        objet_2.addContent(objet_2_code);objet_2.addContent(objet_2_des);objet_2.addContent(objet_2_qt);

        Element objet_3 = new Element("Objet");
        Element objet_3_code = new Element("Code");objet_3_code.setText("0000006");
        Element objet_3_des= new Element("Description");objet_3_des.setText("TABLES_PLASTIQUES");
        Element objet_3_qt= new Element("Quantite");objet_3_qt.setText("0");
        objet_3.addContent(objet_3_code);objet_3.addContent(objet_3_des);objet_3.addContent(objet_3_qt);

        Element objet_4 = new Element("Objet");
        Element objet_4_code = new Element("Code");objet_4_code.setText("0000007");
        Element objet_4_des= new Element("Description");objet_4_des.setText("TABLE_PAILLASSE");
        Element objet_4_qt= new Element("Quantite");objet_4_qt.setText("0");
        objet_4.addContent(objet_4_code);objet_4.addContent(objet_4_des);objet_4.addContent(objet_4_qt);

        Element objet_5 = new Element("Objet");
        Element objet_5_code = new Element("Code");objet_5_code.setText("0000008");
        Element objet_5_des= new Element("Description");objet_5_des.setText("TABLE_DIANA");
        Element objet_5_qt= new Element("Quantite");objet_5_qt.setText("0");
        objet_5.addContent(objet_5_code);objet_5.addContent(objet_5_des);objet_5.addContent(objet_5_qt);

        Element objet_6 = new Element("Objet");
        Element objet_6_code = new Element("Code");objet_6_code.setText("0000009");
        Element objet_6_des= new Element("Description");objet_6_des.setText("TABLES_EN_INOX");
        Element objet_6_qt= new Element("Quantite");objet_6_qt.setText("0");
        objet_6.addContent(objet_6_code);objet_6.addContent(objet_6_des);objet_6.addContent(objet_6_qt);

        Element objet_7 = new Element("Objet");
        Element objet_7_code = new Element("Code");objet_7_code.setText("0000010");
        Element objet_7_des= new Element("Description");objet_7_des.setText("TABLE_DOUBLE_FACE");
        Element objet_7_qt= new Element("Quantite");objet_7_qt.setText("0");
        objet_7.addContent(objet_7_code);objet_7.addContent(objet_7_des);objet_7.addContent(objet_7_qt);

        Element objet_8 = new Element("Objet");
        Element objet_8_code = new Element("Code");objet_8_code.setText("0000011");
        Element objet_8_des= new Element("Description");objet_8_des.setText("TABLE_REUNION");
        Element objet_8_qt= new Element("Quantite");objet_8_qt.setText("0");
        objet_8.addContent(objet_8_code);objet_8.addContent(objet_8_des);objet_8.addContent(objet_8_qt);

        Element objet_9 = new Element("Objet");
        Element objet_9_code = new Element("Code");objet_9_code.setText("0000012");
        Element objet_9_des= new Element("Description");objet_9_des.setText("STRUCTURE_TABLE");
        Element objet_9_qt= new Element("Quantite");objet_9_qt.setText("0");
        objet_9.addContent(objet_9_code);objet_9.addContent(objet_9_des);objet_9.addContent(objet_9_qt);

        Element objet_10 = new Element("Objet");
        Element objet_10_code = new Element("Code");objet_10_code.setText("0000013");
        Element objet_10_des= new Element("Description");objet_10_des.setText("TABLEAU_D'AFFICHAGE");
        Element objet_10_qt= new Element("Quantite");objet_10_qt.setText("0");
        objet_10.addContent(objet_10_code);objet_10.addContent(objet_10_des);objet_10.addContent(objet_10_qt);


        Element objet_11 = new Element("Objet");
        Element objet_11_code = new Element("Code");objet_11_code.setText("0000014");
        Element objet_11_des= new Element("Description");objet_11_des.setText("TABLEAUX_METALLIQUES");
        Element objet_11_qt= new Element("Quantite");objet_11_qt.setText("0");
        objet_11.addContent(objet_11_code);objet_11.addContent(objet_11_des);objet_11.addContent(objet_11_qt);

        Element objet_12 = new Element("Objet");
        Element objet_12_code = new Element("Code");objet_12_code.setText("0000015");
        Element objet_12_des= new Element("Description");objet_12_des.setText("TABLEAU_MAGIQUE");
        Element objet_12_qt= new Element("Quantite");objet_12_qt.setText("0");
        objet_12.addContent(objet_12_code);objet_12.addContent(objet_12_des);objet_12.addContent(objet_12_qt);

        Element objet_13 = new Element("Objet");
        Element objet_13_code = new Element("Code");objet_13_code.setText("0000016");
        Element objet_13_des= new Element("Description");objet_13_des.setText("TABLEAUS_MAGNATIQUES_BLANC_EMAILLES");
        Element objet_13_qt= new Element("Quantite");objet_13_qt.setText("0");
        objet_13.addContent(objet_13_code);objet_13.addContent(objet_13_des);objet_13.addContent(objet_13_qt);

        Element objet_14 = new Element("Objet");
        Element objet_14_code = new Element("Code");objet_14_code.setText("0000017");
        Element objet_14_des= new Element("Description");objet_14_des.setText("TABLEAU_EN_BOIS");
        Element objet_14_qt= new Element("Quantite");objet_14_qt.setText("0");
        objet_14.addContent(objet_14_code);objet_14.addContent(objet_14_des);objet_14.addContent(objet_14_qt);

        Element objet_15 = new Element("Objet");
        Element objet_15_code = new Element("Code");objet_15_code.setText("0000018");
        Element objet_15_des= new Element("Description");objet_15_des.setText("_TABLE_DOUBLE_FACE");
        Element objet_15_qt= new Element("Quantite");objet_15_qt.setText("0");
        objet_15.addContent(objet_15_code);objet_15.addContent(objet_15_des);objet_15.addContent(objet_15_qt);

        Element objet_16 = new Element("Objet");
        Element objet_16_code = new Element("Code");objet_16_code.setText("0000020");
        Element objet_16_des= new Element("Description");objet_16_des.setText("BANQUETTE");
        Element objet_16_qt= new Element("Quantite");objet_16_qt.setText("0");
        objet_16.addContent(objet_16_code);objet_16.addContent(objet_16_des);objet_16.addContent(objet_16_qt);

        Element objet_17 = new Element("Objet");
        Element objet_17_code = new Element("Code");objet_17_code.setText("0000021");
        Element objet_17_des= new Element("Description");objet_17_des.setText("CHAISE_ENFANT");
        Element objet_17_qt= new Element("Quantite");objet_17_qt.setText("0");
        objet_17.addContent(objet_17_code);objet_17.addContent(objet_17_des);objet_17.addContent(objet_17_qt);

        Element objet_18 = new Element("Objet");
        Element objet_18_code = new Element("Code");objet_18_code.setText("0000022");
        Element objet_18_des= new Element("Description");objet_18_des.setText("CHAISE_FORMICA");
        Element objet_18_qt= new Element("Quantite");objet_18_qt.setText("0");
        objet_18.addContent(objet_18_code);objet_18.addContent(objet_18_des);objet_18.addContent(objet_18_qt);

        Element objet_19 = new Element("Objet");
        Element objet_19_code = new Element("Code");objet_19_code.setText("0000023");
        Element objet_19_des= new Element("Description");objet_19_des.setText("CHAISES_DE_REUNION");
        Element objet_19_qt= new Element("Quantite");objet_19_qt.setText("0");
        objet_19.addContent(objet_19_code);objet_19.addContent(objet_19_des);objet_19.addContent(objet_19_qt);


        Element objet_20 = new Element("Objet");
        Element objet_20_code = new Element("Code");objet_20_code.setText("0000024");
        Element objet_20_des= new Element("Description");objet_20_des.setText("CHAISES_ROULANTS");
        Element objet_20_qt= new Element("Quantite");objet_20_qt.setText("0");
        objet_20.addContent(objet_20_code);objet_20.addContent(objet_20_des);objet_20.addContent(objet_20_qt);

        Element objet_30 = new Element("Objet");
        Element objet_30_code = new Element("Code");objet_30_code.setText("0000025");
        Element objet_30_des= new Element("Description");objet_30_des.setText("CHAIS_PLASTIQUES");
        Element objet_30_qt= new Element("Quantite");objet_30_qt.setText("0");
        objet_30.addContent(objet_30_code);objet_30.addContent(objet_30_des);objet_30.addContent(objet_30_qt);

        Element objet_21 = new Element("Objet");
        Element objet_21_code = new Element("Code");objet_21_code.setText("0000026");
        Element objet_21_des= new Element("Description");objet_21_des.setText("CHAISES_EN_BOIS");
        Element objet_21_qt= new Element("Quantite");objet_21_qt.setText("0");
        objet_21.addContent(objet_21_code);objet_21.addContent(objet_21_des);objet_21.addContent(objet_21_qt);

        Element objet_22 = new Element("Objet");
        Element objet_22_code = new Element("Code");objet_22_code.setText("0000027");
        Element objet_22_des= new Element("Description");objet_22_des.setText("CHAISE_PULL");
        Element objet_22_qt= new Element("Quantite");objet_22_qt.setText("0");
        objet_22.addContent(objet_22_code);objet_22.addContent(objet_22_des);objet_22.addContent(objet_22_qt);

        Element objet_23 = new Element("Objet");
        Element objet_23_code = new Element("Code");objet_23_code.setText("0000028");
        Element objet_23_des= new Element("Description");objet_23_des.setText("CHAISE_DIAMENT");
        Element objet_23_qt= new Element("Quantite");objet_23_qt.setText("0");
        objet_23.addContent(objet_23_code);objet_23.addContent(objet_23_des);objet_23.addContent(objet_23_qt);

        Element objet_24 = new Element("Objet");
        Element objet_24_code = new Element("Code");objet_24_code.setText("0000029");
        Element objet_24_des= new Element("Description");objet_24_des.setText("CLIMATISEUR");
        Element objet_24_qt= new Element("Quantite");objet_24_qt.setText("0");
        objet_24.addContent(objet_24_code);objet_24.addContent(objet_24_des);objet_24.addContent(objet_24_qt);

        Element objet_25 = new Element("Objet");
        Element objet_25_code = new Element("Code");objet_25_code.setText("0000030");
        Element objet_25_des= new Element("Description");objet_25_des.setText("REFRIGERATEUR");
        Element objet_25_qt= new Element("Quantite");objet_25_qt.setText("0");
        objet_25.addContent(objet_25_code);objet_25.addContent(objet_25_des);objet_25.addContent(objet_25_qt);

        Element objet_26 = new Element("Objet");
        Element objet_26_code = new Element("Code");objet_26_code.setText("0000031");
        Element objet_26_des= new Element("Description");objet_26_des.setText("MACHINE_A_LAVER");
        Element objet_26_qt= new Element("Quantite");objet_26_qt.setText("0");
        objet_26.addContent(objet_26_code);objet_26.addContent(objet_26_des);objet_26.addContent(objet_26_qt);

        Element objet_27 = new Element("Objet");
        Element objet_27_code = new Element("Code");objet_27_code.setText("0000032");
        Element objet_27_des= new Element("Description");objet_27_des.setText("CHAUFFE_BAIN");
        Element objet_27_qt= new Element("Quantite");objet_27_qt.setText("0");
        objet_27.addContent(objet_27_code);objet_27.addContent(objet_27_des);objet_27.addContent(objet_27_qt);

        Element objet_28 = new Element("Objet");
        Element objet_28_code = new Element("Code");objet_28_code.setText("0000033");
        Element objet_28_des= new Element("Description");objet_28_des.setText("CHAUFFAGE_ELECTRIQUE");
        Element objet_28_qt= new Element("Quantite");objet_28_qt.setText("0");
        objet_28.addContent(objet_28_code);objet_28.addContent(objet_28_des);objet_28.addContent(objet_28_qt);

        Element objet_29 = new Element("Objet");
        Element objet_29_code = new Element("Code");objet_29_code.setText("0000034");
        Element objet_29_des= new Element("Description");objet_29_des.setText("MICRO_ONDE");
        Element objet_29_qt= new Element("Quantite");objet_29_qt.setText("0");
        objet_29.addContent(objet_29_code);objet_29.addContent(objet_29_des);objet_29.addContent(objet_29_qt);


        Element objet_31 = new Element("Objet");
        Element objet_31_code = new Element("Code");objet_31_code.setText("0000035");
        Element objet_31_des= new Element("Description");objet_31_des.setText("FOUR");
        Element objet_31_qt= new Element("Quantite");objet_31_qt.setText("0");
        objet_31.addContent(objet_31_code);objet_31.addContent(objet_31_des);objet_31.addContent(objet_31_qt);

        Element objet_32 = new Element("Objet");
        Element objet_32_code = new Element("Code");objet_32_code.setText("0000036");
        Element objet_32_des= new Element("Description");objet_32_des.setText("PLAQUES");
        Element objet_32_qt= new Element("Quantite");objet_32_qt.setText("0");
        objet_32.addContent(objet_32_code);objet_32.addContent(objet_32_des);objet_32.addContent(objet_32_qt);

        Element objet_33 = new Element("Objet");
        Element objet_33_code = new Element("Code");objet_33_code.setText("0000037");
        Element objet_33_des= new Element("Description");objet_33_des.setText("PROJECTEUR_150");
        Element objet_33_qt= new Element("Quantite");objet_33_qt.setText("0");
        objet_33.addContent(objet_33_code);objet_33.addContent(objet_33_des);objet_33.addContent(objet_33_qt);

        Element objet_34 = new Element("Objet");
        Element objet_34_code = new Element("Code");objet_34_code.setText("0000038");
        Element objet_34_des= new Element("Description");objet_34_des.setText("VIDEO_PROJECTEUR");
        Element objet_34_qt= new Element("Quantite");objet_34_qt.setText("0");
        objet_34.addContent(objet_34_code);objet_34.addContent(objet_34_des);objet_34.addContent(objet_34_qt);

        Element objet_35 = new Element("Objet");
        Element objet_35_code = new Element("Code");objet_35_code.setText("0000039");
        Element objet_35_des= new Element("Description");objet_35_des.setText("APPAREIL_PHOTO_NUMERIQUE");
        Element objet_35_qt= new Element("Quantite");objet_35_qt.setText("0");
        objet_35.addContent(objet_35_code);objet_35.addContent(objet_35_des);objet_35.addContent(objet_35_qt);

        Element objet_36 = new Element("Objet");
        Element objet_36_code = new Element("Code");objet_36_code.setText("0000040");
        Element objet_36_des= new Element("Description");objet_36_des.setText("ECRAN_LED_SAMSUNG");
        Element objet_36_qt= new Element("Quantite");objet_36_qt.setText("0");
        objet_36.addContent(objet_36_code);objet_36.addContent(objet_36_des);objet_36.addContent(objet_36_qt);

        Element objet_37 = new Element("Objet");
        Element objet_37_code = new Element("Code");objet_37_code.setText("0000041");
        Element objet_37_des= new Element("Description");objet_37_des.setText("PHOTOCOPIEUSE");
        Element objet_37_qt= new Element("Quantite");objet_37_qt.setText("0");
        objet_37.addContent(objet_37_code);objet_37.addContent(objet_37_des);objet_37.addContent(objet_37_qt);

        Element objet_38 = new Element("Objet");
        Element objet_38_code = new Element("Code");objet_38_code.setText("0000042");
        Element objet_38_des= new Element("Description");objet_38_des.setText("FAX_SHARP");
        Element objet_38_qt= new Element("Quantite");objet_38_qt.setText("0");
        objet_38.addContent(objet_38_code);objet_38.addContent(objet_38_des);objet_38.addContent(objet_38_qt);

        Element objet_39 = new Element("Objet");
        Element objet_39_code = new Element("Code");objet_39_code.setText("0000043");
        Element objet_39_des= new Element("Description");objet_39_des.setText("CHAINE");
        Element objet_39_qt= new Element("Quantite");objet_39_qt.setText("0");
        objet_39.addContent(objet_39_code);objet_39.addContent(objet_39_des);objet_39.addContent(objet_39_qt);

        Element objet_41 = new Element("Objet");
        Element objet_41_code = new Element("Code");objet_41_code.setText("0000044");
        Element objet_41_des= new Element("Description");objet_41_des.setText("DVD");
        Element objet_41_qt= new Element("Quantite");objet_41_qt.setText("0");
        objet_41.addContent(objet_41_code);objet_41.addContent(objet_41_des);objet_41.addContent(objet_41_qt);

        Element objet_42 = new Element("Objet");
        Element objet_42_code = new Element("Code");objet_42_code.setText("0000045");
        Element objet_42_des= new Element("Description");objet_42_des.setText("TV");
        Element objet_42_qt= new Element("Quantite");objet_42_qt.setText("0");
        objet_42.addContent(objet_42_code);objet_42.addContent(objet_42_des);objet_42.addContent(objet_42_qt);

        Element objet_43 = new Element("Objet");
        Element objet_43_code = new Element("Code");objet_43_code.setText("0000046");
        Element objet_43_des= new Element("Description");objet_43_des.setText("VENTILATEURS");
        Element objet_43_qt= new Element("Quantite");objet_43_qt.setText("0");
        objet_43.addContent(objet_43_code);objet_43.addContent(objet_43_des);objet_43.addContent(objet_43_qt);

        Element objet_44 = new Element("Objet");
        Element objet_44_code = new Element("Code");objet_44_code.setText("0000047");
        Element objet_44_des= new Element("Description");objet_44_des.setText("BAFFLE_AMPLIFIE");
        Element objet_44_qt= new Element("Quantite");objet_44_qt.setText("0");
        objet_44.addContent(objet_44_code);objet_44.addContent(objet_44_des);objet_44.addContent(objet_44_qt);

        Element objet_45 = new Element("Objet");
        Element objet_45_code = new Element("Code");objet_45_code.setText("0000048");
        Element objet_45_des= new Element("Description");objet_45_des.setText("RADIATEUR_HALOGENE");
        Element objet_45_qt= new Element("Quantite");objet_45_qt.setText("0");
        objet_45.addContent(objet_45_code);objet_45.addContent(objet_45_des);objet_45.addContent(objet_45_qt);

        Element objet_46 = new Element("Objet");
        Element objet_46_code = new Element("Code");objet_46_code.setText("0000049");
        Element objet_46_des= new Element("Description");objet_46_des.setText("RADIO_CD");
        Element objet_46_qt= new Element("Quantite");objet_46_qt.setText("0");
        objet_46.addContent(objet_46_code);objet_46.addContent(objet_46_des);objet_46.addContent(objet_46_qt);

        Element objet_47 = new Element("Objet");
        Element objet_47_code = new Element("Code");objet_47_code.setText("0000050");
        Element objet_47_des= new Element("Description");objet_47_des.setText("CAMERA");
        Element objet_47_qt= new Element("Quantite");objet_47_qt.setText("0");
        objet_47.addContent(objet_47_code);objet_47.addContent(objet_47_des);objet_47.addContent(objet_47_qt);

        Element objet_48 = new Element("Objet");
        Element objet_48_code = new Element("Code");objet_48_code.setText("0000051");
        Element objet_48_des= new Element("Description");objet_48_des.setText("MICROSCOPE");
        Element objet_48_qt= new Element("Quantite");objet_48_qt.setText("0");
        objet_48.addContent(objet_48_code);objet_48.addContent(objet_48_des);objet_48.addContent(objet_48_qt);

        Element objet_49 = new Element("Objet");
        Element objet_49_code = new Element("Code");objet_49_code.setText("0000052");
        Element objet_49_des= new Element("Description");objet_49_des.setText("BALANCE");
        Element objet_49_qt= new Element("Quantite");objet_49_qt.setText("0");
        objet_49.addContent(objet_49_code);objet_49.addContent(objet_49_des);objet_49.addContent(objet_49_qt);





        objets.addContent(objet_0);
        objets.addContent(objet_01);
        objets.addContent(objet_02);


        objets.addContent(objet_1);
        objets.addContent(objet_2);
       /* objets.addContent(objet_3);
        objets.addContent(objet_4);
        objets.addContent(objet_5);
        objets.addContent(objet_6);
        objets.addContent(objet_7);
        objets.addContent(objet_8);
        objets.addContent(objet_9);
        objets.addContent(objet_10);

        objets.addContent(objet_11);
        objets.addContent(objet_12);
        objets.addContent(objet_13);
        objets.addContent(objet_14);
        objets.addContent(objet_15);
        objets.addContent(objet_16);
        objets.addContent(objet_17);
        objets.addContent(objet_18);
        objets.addContent(objet_19);
        objets.addContent(objet_20);
/*
        objets.addContent(objet_21);
        objets.addContent(objet_22);
        objets.addContent(objet_23);
        objets.addContent(objet_24);
        objets.addContent(objet_25);
        objets.addContent(objet_26);
        objets.addContent(objet_27);
        objets.addContent(objet_28);
        objets.addContent(objet_29);
        objets.addContent(objet_30);

        objets.addContent(objet_31);
        objets.addContent(objet_32);
        objets.addContent(objet_33);
        objets.addContent(objet_34);
        objets.addContent(objet_35);
        objets.addContent(objet_36);
        objets.addContent(objet_37);
        objets.addContent(objet_38);
        objets.addContent(objet_39);

        objets.addContent(objet_41);
        objets.addContent(objet_42);
        objets.addContent(objet_43);
        objets.addContent(objet_44);
        objets.addContent(objet_45);
        objets.addContent(objet_46);
        objets.addContent(objet_47);
        objets.addContent(objet_48);
        objets.addContent(objet_49);*/


        Document document = new Document(objets);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {

            sortie.output(document, new FileOutputStream("./src/code.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "/test-stock" ,method = RequestMethod.POST)
    public String codeff () throws FileNotFoundException {

        try {

            Element objets = new Element("Produits");


            try (BufferedReader csvReader = new BufferedReader(new FileReader("./src/NMA.csv"))) {
                String row; int i = 1 ;
                while ((row = csvReader.readLine()) != null) {

                    String[] data = row.split(";");
                    System.out.println(data[0]);
                    Element objet = new Element("produit");
                    Element objet_code = new Element("Id");objet_code.setText(i+"");
                    Element objet_des= new Element("Ref");objet_des.setText(data[1]);
                    Element objet_qt= new Element("Quantite");objet_qt.setText("5");
                    Element objet_prix= new Element("Prix");objet_prix.setText("25");
                    objet.addContent(objet_code);objet.addContent(objet_des);objet.addContent(objet_qt);objet.addContent(objet_prix);
                    objets.addContent(objet);
                    i++;
                }
                csvReader.close();
            }
            Document document = new Document(objets);
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

            sortie.output(document, new FileOutputStream("./src/teststock1.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping(value = "/code2" ,method = RequestMethod.POST)
    public String code2 () throws FileNotFoundException {

        try {

            Element objets = new Element("Objets");


            try (BufferedReader csvReader = new BufferedReader(new FileReader("./src/CSDB.csv"))) {
                String row;
                while ((row = csvReader.readLine()) != null) {
                    String[] data = row.split(";");
                    System.out.println(data[0]);
                    Element objet = new Element("Objet");
                    Element objet_code = new Element("Code");objet_code.setText(data[0]);
                    Element objet_des= new Element("Description");objet_des.setText(data[1]);
                    Element objet_qt= new Element("Quantite");objet_qt.setText("0");
                    objet.addContent(objet_code);objet.addContent(objet_des);objet.addContent(objet_qt);
                    objets.addContent(objet);
                }
                csvReader.close();
            }
            Document document = new Document(objets);
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

            sortie.output(document, new FileOutputStream("./src/CSDB.xml"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();


            } catch (IOException e) {
                e.printStackTrace();
            }
            return "ok";
    }
    // --------initialisation des variables  par défaut  --------
    @RequestMapping(value = "/Init_Donnees" ,method = RequestMethod.POST)
    public String   init ()
    {

        Element racine = new Element("Infonet");
        Element root = new Element("Donnees");

        Element cat_fr = new Element("Categorie_Fournisseur");
         Element cat_fr1 = new Element("Revendeur");cat_fr1.setText("10");
        Element cat_fr2 = new Element("Semi_Revendeur");cat_fr2.setText("15");
        Element cat_fr3 = new Element("Producteur");cat_fr3.setText("20");

        Element cat_clt = new Element("Categorie_Client");
         Element cat_clt1 = new Element("Passager");cat_clt1.setText("35");
        Element cat_clt2 = new Element("Fidèle");cat_clt2.setText("30");
        Element cat_clt3 = new Element("SuperFidèle");cat_clt3.setText("25");

        Element banque = new Element("Categorie_Banque");
         Element banque1 = new Element("Biat");banque1.setText("Tunisie");
        Element banque2 = new Element("BH");banque2.setText("Tunisie");


        Element Categorie_Fiscale = new Element("Categorie_Fiscale");
        Element Categorie_Fiscale1 = new Element("Assujetti_tva");
        Element Categorie_Fiscale2 = new Element("Non_Assujetti_tva");
        Element Categorie_Fiscale3 = new Element("Exonéré_tva");
        Element Categorie_Fiscale4 = new Element("Exonéré_tva_et_Fodec");
        Element Categorie_Fiscale5 = new Element("Suspension_tva");
        Element Categorie_Fiscale6 = new Element("Cession_a_quai");
        Element Categorie_Fiscale7 = new Element("Reduction_tva");



        Element Type1 = new Element("Categorie_Type1");
        Element Type11 = new Element("Alimentaire");
        Element Type12 = new Element("Cosmétique");
        Element Type13 = new Element("SemiDurable");
        Element Type14 = new Element("Durable");
        Element Type15 = new Element("Quotidien");

        ///  -----    type 2 ------ ///
        Element Type2 = new Element("Categorie_Type2");
        Element Type21 = new Element("Frais");Type21.setText("Alimentaire");
        Element Type22 = new Element("Embale");Type22.setText("Alimentaire");
        Element Type23 = new Element("Congele");Type23.setText("Alimentaire");
        Element Type24 = new Element("Epices_Sale");Type24.setText("Alimentaire");
        Element Type25 = new Element("Laite");Type25.setText("Alimentaire");
        Element Type26 = new Element("Boissons");Type26.setText("Alimentaire");
        Element Type27 = new Element("Patisserie");Type27.setText("Alimentaire");

        Element Type28 = new Element("Hygene");Type28.setText("Quotidien");
        Element Type29 = new Element("Nettoyage");Type29.setText("Quotidien");
        Element Type210 = new Element("Plastique");Type210.setText("Quotidien");
      //  Element Type211 = new Element("Vaire");Type211.setText("Quotidien");

        Element Type212 = new Element("Parfum");Type212.setText("Cosmétique");
        Element Type213 = new Element("Creme");Type213.setText("Cosmétique");
        Element Type214 = new Element("Parapharmacie");Type214.setText("Cosmétique");
        Element Type215 = new Element("Makiage");Type215.setText("Cosmétique");

        Element Type216 = new Element("Meuble");Type216.setText("SemiDurable");
        Element Type217 = new Element("Education");Type217.setText("SemiDurable");
        Element Type218 = new Element("Vetement");Type218.setText("SemiDurable");
        Element Type219 = new Element("Mecanique");Type219.setText("SemiDurable");
        Element Type220 = new Element("Jouèe");Type220.setText("SemiDurable");
        Element Type221 = new Element("Artisanat");Type221.setText("SemiDurable");
        Element Type222 = new Element("Electricité");Type222.setText("SemiDurable");
        Element Type223 = new Element("Accessoire");Type223.setText("SemiDurable");

        Element Type224 = new Element("Informatique");Type224.setText("Durable");
        Element Type225 = new Element("Electromenager");Type225.setText("Durable");
        Element Type226 = new Element("Automobile");Type226.setText("Durable");
        Element Type227 = new Element("Piece_Rechange");Type227.setText("Durable");
        Element Type228 = new Element("Jardinage");Type228.setText("Durable");





        Element Type3 = new Element("Categorie_Famille");
        Element Type31 = new Element("Viande");Type31.setText("Frais");
        Element Type32 = new Element("Marins");Type32.setText("Frais");
        Element Type33 = new Element("Fruit");Type33.setText("Frais");
        Element Type34 = new Element("legume");Type34.setText("Frais");

        Element Type35 = new Element("yaourt");Type35.setText("Laite");
        Element Type36 = new Element("Formage");Type36.setText("Laite");

        Element Type37 = new Element("Sac");Type37.setText("Embale");
        Element Type38 = new Element("Boite");Type38.setText("Embale");
        Element Type39 = new Element("Carton");Type39.setText("Embale");

        Element Type310 = new Element("Congele");Type310.setText("Congele");
        Element Type311 = new Element("Surgele");Type311.setText("Congele");

        Element Type312 = new Element("Epices");Type312.setText("Epices_Sale");
        Element Type313 = new Element("Sale");Type313.setText("Epices_Sale");

        Element Type314 = new Element("Pain");Type314.setText("Patisserie");
        Element Type315 = new Element("Gateaux");Type315.setText("Patisserie");
        Element Type316 = new Element("sale");Type316.setText("Patisserie");
        Element Type317 = new Element("pizza");Type317.setText("Patisserie");


        Element Type318 = new Element("Juse");Type318.setText("Boissons");
        Element Type319 = new Element("gaze");Type319.setText("Boissons");
        Element Type320 = new Element("Alcole");Type320.setText("Boissons");
        Element Type321 = new Element("Juse_frais");Type321.setText("Boissons");



///*******

        Element Type4 = new Element("Categorie_Sous_Famille");
        Element Type41 = new Element("Rouge");Type41.setText("Viande");
        Element Type42 = new Element("Blanche");Type42.setText("Viande");
        Element Type43 = new Element("Moule");Type43.setText("Marins");
        Element Type44 = new Element("Crevette");Type44.setText("Marins");
        Element Type45 = new Element("poissons");Type45.setText("Marins");
        Element Type46 = new Element("Banane");Type46.setText("Fruit");
        Element Type47 = new Element("Pomme");Type47.setText("Fruit");
        Element Type48 = new Element("Ananas");Type48.setText("Fruit");
        Element Type410 = new Element("Ail");Type410.setText("legume");
        Element Type411 = new Element("Artichaut");Type411.setText("legume");
        Element Type412 = new Element("Pomme_terre");Type412.setText("legume");
        Element Type413 = new Element("Tomate");Type413.setText("legume");
        Element Type414 = new Element("Nature");Type414.setText("yaourt");
        Element Type415 = new Element("Entier");Type415.setText("yaourt");
        Element Type416 = new Element("Brassé");Type416.setText("yaourt");
        Element Type417 = new Element("Brillat_Savarin");Type417.setText("Formage");
        Element Type418 = new Element("Brie_Meaux");Type418.setText("Formage");




        Element Region = new Element("Categorie_Region");
        Element Region1 = new Element("Esskhira");Region1.setText("Sfax");
        Element Region2 = new Element("El_Hencha");Region2.setText("Sfax");
        Element Region3 = new Element("El_Amra");Region3.setText("Sfax");
        Element Region4 = new Element("Bir_Al_Ben_Khelifa");Region4.setText("Sfax");
        Element Region5 = new Element("Agareb");Region5.setText("Sfax");
        Element Region6 = new Element("Ghraiba");Region6.setText("Sfax");
        Element Region7 = new Element("Jebeniana");Region7.setText("Sfax");
        Element Region8 = new Element("Kerkenah");Region8.setText("Sfax");
        Element Region9 = new Element("Mahras");Region9.setText("Sfax");
        Element Region10 = new Element("Menzel_Chaker");Region10.setText("Sfax");
        Element Region11 = new Element("Sakiet_Eddaier");Region11.setText("Sfax");
        Element Region12 = new Element("Sakiet_Ezzit");Region12.setText("Sfax");
        Element Region13 = new Element("Sfax_Est");Region13.setText("Sfax");
        Element Region14 = new Element("Sfax_Sud");Region14.setText("Sfax");
        Element Region15 = new Element("Sfax_Ville");Region15.setText("Sfax");

        Element Region16 = new Element("Ariana_Ville");Region16.setText("Ariana");
        Element Region17 = new Element("Ettadhamen");Region17.setText("Ariana");
        Element Region18 = new Element("Kalaat_Landlous");Region18.setText("Ariana");
        Element Region19 = new Element("Soukra");Region19.setText("Ariana");
        Element Region20 = new Element("Mnihla");Region20.setText("Ariana");
        Element Region21 = new Element("Raoued");Region21.setText("Ariana");
        Element Region22 = new Element("Sidi_Thabet");Region22.setText("Ariana");

        Element Region23 = new Element("Amdoun");Region23.setText("Beja");
        Element Region24 = new Element("Beja_Nord");Region24.setText("Beja");
        Element Region25 = new Element("Beja_Sud");Region25.setText("Beja");
        Element Region26 = new Element("Goubellat");Region26.setText("Beja");
        Element Region27 = new Element("Mejez_El_Bab");Region27.setText("Beja");
        Element Region28 = new Element("Teboursouk");Region28.setText("Beja");
        Element Region29 = new Element("Testour");Region29.setText("Beja");
        Element Region30 = new Element("Thibar");Region30.setText("Beja");

        Element Region31 = new Element("Bou_Mhel_El_Bassatine");Region31.setText("Ben_Arous");
        Element Region32 = new Element("El_Mourouj");Region32.setText("Ben_Arous");
        Element Region33 = new Element("Ezzahra");Region33.setText("Ben_Arous");
        Element Region34 = new Element("Fouchana");Region34.setText("Ben_Arous");
        Element Region35 = new Element("Hammam_Chatt");Region35.setText("Ben_Arous");
        Element Region36 = new Element("Hammam_Lif");Region36.setText("Ben_Arous");
        Element Region37 = new Element("Mohamadia");Region37.setText("Ben_Arous");
        Element Region38 = new Element("Mornag");Region38.setText("Ben_Arous");
        Element Region39 = new Element("Nouvelle_Medina");Region39.setText("Ben_Arous");
        Element Region40 = new Element("Rades");Region40.setText("Ben_Arous");

        Element Region41 = new Element("Bizerte_Nord");Region41.setText("Bizerte");
        Element Region42 = new Element("Bizerte_Sud");Region42.setText("Bizerte");
        Element Region43 = new Element("El_Alia");Region43.setText("Bizerte");
        Element Region44 = new Element("Ghar_El_Melh");Region44.setText("Bizerte");
        Element Region45 = new Element("Ghezala");Region45.setText("Bizerte");
        Element Region46 = new Element("Jarzouna");Region46.setText("Bizerte");
        Element Region47 = new Element("Joumine");Region47.setText("Bizerte");
        Element Region48 = new Element("Mateur");Region48.setText("Bizerte");
        Element Region49 = new Element("Menzel_Bourguiba");Region49.setText("Bizerte");
        Element Region50 = new Element("Menzel_Jemil");Region50.setText("Bizerte");
        Element Region51 = new Element("Ras_Jebel");Region51.setText("Bizerte");
        Element Region52 = new Element("Sejnane");Region52.setText("Bizerte");
        Element Region53 = new Element("Tinja");Region53.setText("Bizerte");
        Element Region54 = new Element("Utique");Region54.setText("Bizerte");

        Element Region55 = new Element("El_Hamma");Region55.setText("Gabes");
        Element Region56 = new Element("El_Metouia");Region56.setText("Gabes");
        Element Region57 = new Element("Gabes_Medina");Region57.setText("Gabes");
        Element Region58 = new Element("Gabes_Ouest");Region58.setText("Gabes");
        Element Region66 = new Element("Gabes_Sud");Region66.setText("Gabes");
        Element Region59 = new Element("Ghannouche");Region59.setText("Gabes");
        Element Region60 = new Element("Mareth");Region60.setText("Gabes");
        Element Region61 = new Element("Matmata");Region61.setText("Gabes");
        Element Region67 = new Element("Menzel_Habib");Region67.setText("Gabes");
        Element Region62 = new Element("Nouvelle_Matmata");Region62.setText("Gabes");

        Element Region63 = new Element("Belkhir");Region63.setText("Gafsa");
        Element Region65 = new Element("El_Guettar");Region65.setText("Gafsa");
        Element Region68 = new Element("El_Ksar");Region68.setText("Gafsa");
        Element Region69 = new Element("El_Mdhilla");Region69.setText("Gafsa");
        Element Region70 = new Element("Gafsa_Nord");Region70.setText("Gafsa");
        Element Region71 = new Element("Gafsa_Sud");Region71.setText("Gafsa");
        Element Region72 = new Element("Metlaoui");Region72.setText("Gafsa");
        Element Region73 = new Element("Moulares");Region73.setText("Gafsa");
        Element Region74 = new Element("Redeyef");Region74.setText("Gafsa");
        Element Region75 = new Element("Sidi_Aich");Region75.setText("Gafsa");
        Element Region76 = new Element("Sned");Region76.setText("Gafsa");

        Element Region77 = new Element("Ain_Draham");Region77.setText("Jendouba");
        Element Region78 = new Element("Balta_Bou_Aouene");Region78.setText("Jendouba");
        Element Region79 = new Element("Bou_Salem");Region79.setText("Jendouba");
        Element Region80 = new Element("Fernana");Region80.setText("Jendouba");
        Element Region81 = new Element("Ghardimaou");Region81.setText("Jendouba");
        Element Region82 = new Element("Jendouba");Region82.setText("Jendouba");
        Element Region83 = new Element("Jendouba_Nord");Region83.setText("Jendouba");
        Element Region84 = new Element("Oued_Mliz");Region84.setText("Jendouba");
        Element Region85 = new Element("Tabarka");Region85.setText("Jendouba");

        Element Region86 = new Element("Bou_Hajla");Region86.setText("Kairouan");
        Element Region87 = new Element("Chebika");Region87.setText("Kairouan");
        Element Region88 = new Element("Cherarda");Region88.setText("Kairouan");
        Element Region89 = new Element("El_Ala");Region89.setText("Kairouan");
        Element Region90 = new Element("Haffouz");Region90.setText("Kairouan");
        Element Region91 = new Element("Hajeb_El_Ayoun");Region91.setText("Kairouan");
        Element Region92 = new Element("Kairouan_Nord");Region92.setText("Kairouan");
        Element Region93 = new Element("Kairouan_Sud");Region93.setText("Kairouan");
        Element Region94 = new Element("Nasrallah");Region94.setText("Kairouan");
        Element Region95 = new Element("Oueslatia");Region95.setText("Kairouan");
        Element Region96 = new Element("Sbikha");Region96.setText("Kairouan");


        Element Region97 = new Element("El_Ayoun");Region97.setText("Kasserine");
        Element Region98 = new Element("Ezzouhour");Region98.setText("Kasserine");
        Element Region99 = new Element("Feriana");Region99.setText("Kasserine");
        Element Region100 = new Element("Foussana");Region100.setText("Kasserine");
        Element Region101 = new Element("Haidra");Region101.setText("Kasserine");
        Element Region102 = new Element("Hassi_El_Frid");Region102.setText("Kasserine");
        Element Region103 = new Element("Jediliane");Region103.setText("Kasserine");
        Element Region104 = new Element("Kasserine_Nord");Region104.setText("Kasserine");
        Element Region105 = new Element("Kasserine_Sud");Region105.setText("Kasserine");
        Element Region106 = new Element("Mejel_Bel_Abbes");Region106.setText("Kasserine");
        Element Region107 = new Element("Sbeitla");Region107.setText("Kasserine");
        Element Region108 = new Element("Sbiba");Region108.setText("Kasserine");
        Element Region109 = new Element("Thala");Region109.setText("Kasserine");

        Element Region110 = new Element("Douz");Region110.setText("Kebili");
        Element Region111 = new Element("El_Faouar");Region111.setText("Kebili");
        Element Region112 = new Element("Kebili_Nord");Region112.setText("Kebili");
        Element Region113 = new Element("Kebili_Sud");Region113.setText("Kebili");
        Element Region114 = new Element("Souk_El_Ahad");Region114.setText("Kebili");

        Element Region115 = new Element("Borj_El_Amri");Region115.setText("Manouba");
        Element Region116 = new Element("Douar_Hicher");Region116.setText("Manouba");
        Element Region117 = new Element("El_Battan");Region117.setText("Manouba");
        Element Region118 = new Element("Jedaida");Region118.setText("Manouba");
        Element Region119 = new Element("Mannouba");Region119.setText("Manouba");
        Element Region120 = new Element("Mornaguia");Region120.setText("Manouba");
        Element Region121 = new Element("Oued_Ellil");Region121.setText("Manouba");
        Element Region122 = new Element("Tebourba");Region122.setText("Manouba");

        Element Region123 = new Element("Dahmani");Region123.setText("Kef");
        Element Region124 = new Element("El_Ksour");Region124.setText("Kef");
        Element Region125 = new Element("Jerissa");Region125.setText("Kef");
        Element Region126 = new Element("Kalaa_El_Khasba");Region126.setText("Kef");
        Element Region127 = new Element("Kalaat_Sinane");Region127.setText("Kef");
        Element Region128 = new Element("Le_Kef_Est");Region128.setText("Kef");
        Element Region129 = new Element("Le_Kef_Ouest");Region129.setText("Kef");
        Element Region130 = new Element("Le_Sers");Region130.setText("Kef");
        Element Region131 = new Element("Nebeur");Region131.setText("Kef");
        Element Region133 = new Element("Sakiet_Sidi_Youssef");Region133.setText("Kef");
        Element Region132 = new Element("Tajerouine");Region132.setText("Kef");
        Element Region134 = new Element("Touiref");Region134.setText("Kef");

        Element Region135 = new Element("Bou_Merdes");Region135.setText("Mahdia");
        Element Region136 = new Element("Chorbane");Region136.setText("Mahdia");
        Element Region137 = new Element("El_Jem");Region137.setText("Mahdia");
        Element Region138 = new Element("Hbira");Region138.setText("Mahdia");
        Element Region139 = new Element("Ksour_Essaf");Region139.setText("Mahdia");
        Element Region140 = new Element("Chebba");Region140.setText("Mahdia");
        Element Region141 = new Element("Mahdia");Region141.setText("Mahdia");
        Element Region142 = new Element("Melloulech");Region142.setText("Mahdia");
        Element Region143 = new Element("Ouled_Chamakh");Region143.setText("Mahdia");
        Element Region144= new Element("Sidi_Alouene");Region144.setText("Mahdia");
        Element Region145 = new Element("Souassi");Region145.setText("Mahdia");

        Element Region146 = new Element("Ajim");Region146.setText("Mednine");
        Element Region147 = new Element("Ben_Guerdane");Region147.setText("Mednine");
        Element Region148 = new Element("Beni_Khedache");Region148.setText("Mednine");
        Element Region149 = new Element("Houmet_Essouk");Region149.setText("Mednine");
        Element Region150 = new Element("Medenine_Nord");Region150.setText("Mednine");
        Element Region151 = new Element("Medenine_Sud");Region151.setText("Mednine");
        Element Region152 = new Element("Midoun");Region152.setText("Mednine");
        Element Region153 = new Element("Sidi_Makhlouf");Region153.setText("Mednine");
        Element Region154 = new Element("Zarzis");Region154.setText("Mednine");

        Element Region155 = new Element("Bekalta");Region155.setText("Monastir");
        Element Region156 = new Element("Bembla");Region156.setText("Monastir");
        Element Region157 = new Element("Beni_Hassen");Region157.setText("Monastir");
        Element Region158 = new Element("Jemmal");Region158.setText("Monastir");
        Element Region159 = new Element("Ksar_Helal");Region159.setText("Monastir");
        Element Region160 = new Element("Ksibet_El_Mediouni");Region160.setText("Monastir");
        Element Region161 = new Element("Moknine");Region161.setText("Monastir");
        Element Region162 = new Element("Monastir");Region162.setText("Monastir");
        Element Region163 = new Element("Sahline");Region163.setText("Monastir");
        Element Region164 = new Element("Teboulba");Region164.setText("Monastir");
        Element Region165 = new Element("Zeramdine");Region165.setText("Monastir");










        Element Pays = new Element("Categorie_Pays");
        Element Pays1 = new Element("Algérie");
        Element Pays2 = new Element("France");
        Element Pays3 = new Element("Italie");
        Element Pays4 = new Element("Turkey");
        Element Pays5 = new Element("Tunisie");


        Element Ville = new Element("Categorie_Ville");
        Element Ville1 = new Element("Sfax");Ville1.setText("Tunisie");
        Element Ville2 = new Element("Ariana");Ville2.setText("Tunisie");
        Element Ville3 = new Element("Ben_Arous");Ville3.setText("Tunisie");
        Element Ville4 = new Element("Gabes");Ville4.setText("Tunisie");
        Element Ville5 = new Element("Gafsa");Ville5.setText("Tunisie");
        Element Ville6 = new Element("Jendouba");Ville6.setText("Tunisie");
        Element Ville7 = new Element("Kairouan");Ville7.setText("Tunisie");
        Element Ville8 = new Element("Kasserine");Ville8.setText("Tunisie");
        Element Ville9 = new Element("Kebili");Ville9.setText("Tunisie");
        Element Ville10 = new Element("Manouba");Ville10.setText("Tunisie");
        Element Ville11 = new Element("Kef");Ville11.setText("Tunisie");
        Element Ville12 = new Element("Mahdia");Ville12.setText("Tunisie");
        Element Ville13 = new Element("Mednine");Ville13.setText("Tunisie");
        Element Ville14 = new Element("Monastir");Ville14.setText("Tunisie");
        Element Ville15 = new Element("Nabeul");Ville15.setText("Tunisie");
        Element Ville16 = new Element("Sidi_Bouzid");Ville16.setText("Tunisie");
        Element Ville17 = new Element("Siliana");Ville17.setText("Tunisie");
        Element Ville18 = new Element("Sousse");Ville18.setText("Tunisie");
        Element Ville19 = new Element("Tataouine");Ville19.setText("Tunisie");
        Element Ville20 = new Element("Tozeur");Ville20.setText("Tunisie");
        Element Ville21 = new Element("Tunis");Ville21.setText("Tunisie");
        Element Ville22 = new Element("Zaghouan");Ville22.setText("Tunisie");
        Element Ville23 = new Element("Beja");Ville23.setText("Tunisie");
        Element Ville24 = new Element("Beja");Ville24.setText("Tunisie");

        Element Tva = new Element("Categorie_Tva");
        Element Tva1 = new Element("Taxe7");Tva1.setText("7");
        Element Tva2 = new Element("Taxe13");Tva2.setText("13");
        Element Tva3 = new Element("Taxe19");Tva3.setText("19");

        Element Ngp = new Element("Categorie_Ngp");
        Element Ngp1 = new Element("N_85171200101_19");
        Element Ngp2 = new Element("N_85171200907_19");
        Element Ngp3 = new Element("N_84719000015_7");
        Element Ngp4 = new Element("N_85444290915_19");
        Element Ngp5 = new Element("N_84733080004_7");




        Element Taxe = new Element("Categorie_Taxe");
        Element Taxe1 = new Element("Taxe001-30");Taxe1.setText("30");
        Element Taxe2 = new Element("Taxe001-15");Taxe2.setText("15");
        Element Taxe3 = new Element("Taxe094");Taxe3.setText("5");
        Element Taxe4 = new Element("Taxe093");Taxe4.setText("1");
        Element Taxe5 = new Element("Taxe105-7");Taxe5.setText("7");
        Element Taxe6 = new Element("Taxe105-13");Taxe6.setText("13");
        Element Taxe7 = new Element("Taxe105-19");Taxe7.setText("19");
        Element Taxe8 = new Element("Taxe473");Taxe8.setText("3");

        Element Local = new Element("Categorie_Local");
        Element Local1 = new Element("Depot");
        Element Local2 = new Element("Point_Vente");
        Element Local3 = new Element("Magasin");

        Element Piece = new Element("Categorie_Piece");
        Element Piece1 = new Element("Cin");
        Element Piece2 = new Element("Batinda");
        Element Piece3 = new Element("Passeport");

        Element Type_paiement = new Element("Categorie_Type_Paiement");
        Element Type_paiement1 = new Element("Cheque");
        Element Type_paiement2 = new Element("Cartes_bancaires");
        Element Type_paiement3 = new Element("Virement");
        Element Type_paiement4 = new Element("Especes");


        Element Unite = new Element("Categorie_Unite");
        Element Unite1 = new Element("Piece");
        Element Unite2 = new Element("Kg");
        Element Unite3 = new Element("m");

        Element Fodec = new Element("Categorie_Fodec");
        Element Fodec1 = new Element("Sans_Fodec");
        Element Fodec2 = new Element("Fodec_Sur_Achat");
        Element Fodec3 = new Element("Fodec_Sur_Vente");


        Element Employe = new Element("Categorie_Employe");
        Element Employe1 = new Element("Simple_ouvrier");
        Element Employe2 = new Element("Technicien");
        Element Employe3 = new Element("Ingénieur");

        Element conge = new Element("Categorie_Congé");
        Element conge1 = new Element("Congé_payé");
        Element conge2 = new Element("Maladie");
        Element conge3 = new Element("Sans_solde");


        Element Agence = new Element("Categorie_Agence_Transitaire");
        Element Agence1 = new Element("TRANSPORT_INTERNATIONAL");
        Element Agence2 = new Element("Agence_Maritime_Mohab");

        Element Agence_transport = new Element("Categorie_Agence_Transport");
        Element Agence_transport1 = new Element("TRANSAF_Affes");
        Element Agence_transport2 = new Element("Hammami_Transport");

        Element Famille_Logistique = new Element("Categorie_Famille_Logistique");
        Element Famille_Logistique1 = new Element("Famille_Logistique1");
        Element Famille_Logistique2 = new Element("Famille_Logistique2");

        Element Sous_Famille_Logistique11 = new Element("Sous_Famille_Logistique11");
        Element Sous_Famille_Logistique12 = new Element("Sous_Famille_Logistique12");

        Element Sous_Famille_Logistique21 = new Element("Sous_Famille_Logistique21");
        Element Sous_Famille_Logistique22 = new Element("Sous_Famille_Logistique22");






////////////////////////////

        racine.addContent(root);

        root.addContent(cat_fr);
         cat_fr.addContent(cat_fr1);
        cat_fr.addContent(cat_fr2);
        cat_fr.addContent(cat_fr3);

        root.addContent(cat_clt);
        cat_clt.addContent(cat_clt1);
        cat_clt.addContent(cat_clt2);
        cat_clt.addContent(cat_clt3);

        root.addContent(Type1);
        Type1.addContent(Type11);
        Type1.addContent(Type12);
        Type1.addContent(Type13);
        Type1.addContent(Type14);
        Type1.addContent(Type15);

        root.addContent(Type2);
        Type2.addContent(Type21);
        Type2.addContent(Type22);
        Type2.addContent(Type23);
        Type2.addContent(Type24);
        Type2.addContent(Type25);
        Type2.addContent(Type26);
        Type2.addContent(Type27);
        Type2.addContent(Type28);
        Type2.addContent(Type29);
        Type2.addContent(Type210);
       // Type2.addContent(Type211);
        Type2.addContent(Type212);
        Type2.addContent(Type213);
        Type2.addContent(Type214);
        Type2.addContent(Type215);
        Type2.addContent(Type216);
        Type2.addContent(Type217);
        Type2.addContent(Type218);
        Type2.addContent(Type219);
        Type2.addContent(Type220);
        Type2.addContent(Type221);
        Type2.addContent(Type222);
        Type2.addContent(Type223);
        Type2.addContent(Type224);
        Type2.addContent(Type225);
        Type2.addContent(Type226);
        Type2.addContent(Type227);
        Type2.addContent(Type228);




        root.addContent(Type3);
        Type3.addContent(Type31);
        Type3.addContent(Type32);
        Type3.addContent(Type33);
        Type3.addContent(Type34);
        Type3.addContent(Type35);
        Type3.addContent(Type36);
        Type3.addContent(Type37);
        Type3.addContent(Type38);
        Type3.addContent(Type39);
        Type3.addContent(Type310);
        Type3.addContent(Type311);
        Type3.addContent(Type312);
        Type3.addContent(Type313);
        Type3.addContent(Type314);
        Type3.addContent(Type315);
        Type3.addContent(Type316);
        Type3.addContent(Type317);
        Type3.addContent(Type318);
        Type3.addContent(Type319);
        Type3.addContent(Type320);
        Type3.addContent(Type321);


        root.addContent(Type4);
        Type4.addContent(Type41);
        Type4.addContent(Type42);
        Type4.addContent(Type43);
        Type4.addContent(Type44);
        Type4.addContent(Type45);
        Type4.addContent(Type46);
        Type4.addContent(Type47);
        Type4.addContent(Type48);
        Type4.addContent(Type410);
        Type4.addContent(Type411);
        Type4.addContent(Type412);
        Type4.addContent(Type413);
        Type4.addContent(Type414);
        Type4.addContent(Type415);
        Type4.addContent(Type416);
        Type4.addContent(Type417);
        Type4.addContent(Type418);



        root.addContent(Region);
        Region.addContent(Region1);
        Region.addContent(Region2);
        Region.addContent(Region3);
        Region.addContent(Region4);
        Region.addContent(Region5);
        Region.addContent(Region6);
        Region.addContent(Region7);
        Region.addContent(Region8);
        Region.addContent(Region9);
        Region.addContent(Region10);
        Region.addContent(Region11);
        Region.addContent(Region12);
        Region.addContent(Region13);
        Region.addContent(Region14);
        Region.addContent(Region15);
        Region.addContent(Region16);
        Region.addContent(Region17);
        Region.addContent(Region18);
        Region.addContent(Region19);
        Region.addContent(Region20);
        Region.addContent(Region21);
        Region.addContent(Region22);
        Region.addContent(Region23);
        Region.addContent(Region24);
        Region.addContent(Region25);
        Region.addContent(Region26);
        Region.addContent(Region27);
        Region.addContent(Region28);
        Region.addContent(Region29);
        Region.addContent(Region30);
        Region.addContent(Region31);
        Region.addContent(Region32);
        Region.addContent(Region33);
        Region.addContent(Region34);
        Region.addContent(Region35);
        Region.addContent(Region36);
        Region.addContent(Region37);
        Region.addContent(Region38);
        Region.addContent(Region39);
        Region.addContent(Region40);

        Region.addContent( Region41);
        Region.addContent( Region42  );
        Region.addContent( Region43  );
        Region.addContent( Region44  );
        Region.addContent( Region45  );
        Region.addContent( Region46 );
        Region.addContent( Region47  );
        Region.addContent( Region48  );
        Region.addContent( Region49  );
        Region.addContent( Region50  );
        Region.addContent( Region51  );
        Region.addContent( Region52  );
        Region.addContent( Region53  );
        Region.addContent( Region54 );

        Region.addContent( Region55  );
        Region.addContent( Region56  );
        Region.addContent( Region57  );
        Region.addContent( Region58  );
        Region.addContent( Region66  );
        Region.addContent( Region59  );
        Region.addContent( Region60  );
        Region.addContent( Region61  );
        Region.addContent( Region67  );
        Region.addContent( Region62  );

        Region.addContent( Region63  );
        Region.addContent( Region65  );
        Region.addContent( Region68  );
        Region.addContent( Region69  );
        Region.addContent( Region70  );
        Region.addContent( Region71  );
        Region.addContent( Region72  );
        Region.addContent( Region73  );
        Region.addContent( Region74  );
        Region.addContent( Region75  );
        Region.addContent( Region76  );

        Region.addContent( Region77  );
        Region.addContent( Region78  );
        Region.addContent( Region79  );
        Region.addContent( Region80  );
        Region.addContent( Region81  );
        Region.addContent( Region82  );
        Region.addContent( Region83  );
        Region.addContent( Region84  );
        Region.addContent( Region85  );

        Region.addContent( Region86  );
        Region.addContent( Region87  );
        Region.addContent( Region88  );
        Region.addContent( Region89  );
        Region.addContent( Region90  );
        Region.addContent( Region91  );
        Region.addContent( Region92  );
        Region.addContent( Region93  );
        Region.addContent( Region94  );
        Region.addContent( Region95  );
        Region.addContent( Region96  );


        Region.addContent( Region97  );
        Region.addContent( Region98  );
        Region.addContent( Region99  );
        Region.addContent( Region100  );
        Region.addContent( Region101  );
        Region.addContent( Region102 );
        Region.addContent( Region103 );
        Region.addContent( Region104  );
        Region.addContent( Region105  );
        Region.addContent( Region106  );
        Region.addContent( Region107  );
        Region.addContent( Region108  );
        Region.addContent( Region109  );

        Region.addContent( Region110  );
        Region.addContent( Region111  );
        Region.addContent( Region112  );
        Region.addContent( Region113  );
        Region.addContent( Region114  );

        Region.addContent( Region115    );
        Region.addContent( Region116  );
        Region.addContent(  Region117  );
        Region.addContent( Region118  );
        Region.addContent( Region119  );
        Region.addContent( Region120  );
        Region.addContent( Region121  );
        Region.addContent( Region122  );

        Region.addContent( Region123  );
        Region.addContent( Region124  );
        Region.addContent( Region125  );
        Region.addContent( Region126  );
        Region.addContent( Region127  );
        Region.addContent( Region128  );
        Region.addContent( Region129  );
        Region.addContent( Region130  );
        Region.addContent( Region131  );
        Region.addContent( Region133  );
        Region.addContent( Region132  );
        Region.addContent( Region134  );

        Region.addContent( Region135  );
        Region.addContent( Region136  );
        Region.addContent( Region137  );
        Region.addContent( Region138  );
        Region.addContent( Region139  );
        Region.addContent( Region140  );
        Region.addContent( Region141  );
        Region.addContent( Region142  );
        Region.addContent( Region143  );
        Region.addContent( Region144 );
        Region.addContent( Region145  );

        Region.addContent( Region146  );
        Region.addContent( Region147  );
        Region.addContent( Region148  );
        Region.addContent( Region149  );
        Region.addContent( Region150  );
        Region.addContent( Region151  );
        Region.addContent( Region152  );
        Region.addContent( Region153  );
        Region.addContent( Region154  );

        Region.addContent( Region155  );
        Region.addContent( Region156  );
        Region.addContent( Region157  );
        Region.addContent( Region158  );
        Region.addContent( Region159  );
        Region.addContent( Region160  );
        Region.addContent( Region161  );
        Region.addContent( Region162  );
        Region.addContent( Region163  );
        Region.addContent( Region164  );
        Region.addContent( Region165  );








        root.addContent(Pays);
        Pays.addContent(Pays1);
        Pays.addContent(Pays2);
        Pays.addContent(Pays3);
        Pays.addContent(Pays4);
        Pays.addContent(Pays5);


        root.addContent(Ville);
        Ville.addContent(Ville1);
        Ville.addContent(Ville2);
        Ville.addContent(Ville3);
        Ville.addContent(Ville4);
        Ville.addContent(Ville5);
        Ville.addContent(Ville6);
        Ville.addContent(Ville7);
        Ville.addContent(Ville8);
        Ville.addContent(Ville9);
        Ville.addContent(Ville10);
        Ville.addContent(Ville11);
        Ville.addContent(Ville12);
        Ville.addContent(Ville13);
        Ville.addContent(Ville14);
        Ville.addContent(Ville15);
        Ville.addContent(Ville16);
        Ville.addContent(Ville17);
        Ville.addContent(Ville18);
        Ville.addContent(Ville19);
        Ville.addContent(Ville20);
        Ville.addContent(Ville21);
        Ville.addContent(Ville22);
        Ville.addContent(Ville23);
        Ville.addContent(Ville24);

        root.addContent(Tva);
        Tva.addContent(Tva1);
        Tva.addContent(Tva2);
        Tva.addContent(Tva3);

        root.addContent(Ngp);
        Ngp.addContent(Ngp1);
        Ngp.addContent(Ngp2);
        Ngp.addContent(Ngp3);



        root.addContent(Local);
        Local.addContent(Local1);
        Local.addContent(Local2);
        Local.addContent(Local3);

        root.addContent(Piece);
         Piece.addContent(Piece1);
        Piece.addContent(Piece2);
        Piece.addContent(Piece3);

        root.addContent(banque);
        banque.addContent(banque1);
        banque.addContent(banque2);


        root.addContent(Categorie_Fiscale);
        Categorie_Fiscale.addContent(Categorie_Fiscale1);
        Categorie_Fiscale.addContent(Categorie_Fiscale2);
        Categorie_Fiscale.addContent(Categorie_Fiscale3);
        Categorie_Fiscale.addContent(Categorie_Fiscale4);
        Categorie_Fiscale.addContent(Categorie_Fiscale5);
        Categorie_Fiscale.addContent(Categorie_Fiscale6);
        Categorie_Fiscale.addContent(Categorie_Fiscale7);


        root.addContent(Type_paiement);
        Type_paiement.addContent(Type_paiement1);
        Type_paiement.addContent(Type_paiement2);
        Type_paiement.addContent(Type_paiement3);
        Type_paiement.addContent(Type_paiement4);

        root.addContent(Unite);
        Unite.addContent(Unite1);
        Unite.addContent(Unite2);
        Unite.addContent(Unite3);


        root.addContent(Fodec);
        Fodec.addContent(Fodec1);
        Fodec.addContent(Fodec2);
        Fodec.addContent(Fodec3);

        root.addContent(Employe);
        Employe.addContent(Employe1);
        Employe.addContent(Employe2);
        Employe.addContent(Employe3);

        root.addContent(conge);
        conge.addContent(conge1);
        conge.addContent(conge2);
        conge.addContent(conge3);

        root.addContent(Taxe);
        Taxe.addContent(Taxe1);
        Taxe.addContent(Taxe2);
        Taxe.addContent(Taxe3);
        Taxe.addContent(Taxe4);
        Taxe.addContent(Taxe5);
        Taxe.addContent(Taxe6);
        Taxe.addContent(Taxe7);
        Taxe.addContent(Taxe8);

        root.addContent(Agence);
        Agence.addContent(Agence1);
        Agence.addContent(Agence2);

        root.addContent(Agence_transport);
        Agence_transport.addContent(Agence_transport1);
        Agence_transport.addContent(Agence_transport2);

        root.addContent(Famille_Logistique);
        Famille_Logistique.addContent(Famille_Logistique1);
        Famille_Logistique.addContent(Famille_Logistique2);

        Famille_Logistique1.addContent(Sous_Famille_Logistique11);
        Famille_Logistique1.addContent(Sous_Famille_Logistique12);

        Famille_Logistique2.addContent(Sous_Famille_Logistique21);
        Famille_Logistique2.addContent(Sous_Famille_Logistique22);



        Ngp1.addContent(new Element("Taxe001-30"));
        Ngp1.addContent(new Element("Taxe001-15"));

        Document document = new Document(racine);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {

            sortie.output(document, new FileOutputStream("./src/Donnnee.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /// ------------    liste des categorie
    @RequestMapping(value = "/Liste_Categorie" ,method = RequestMethod.GET)
    public List<String> Liste_Categorie() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {

            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<String> liste = new ArrayList<>();
        for (Element clt : l) {

            liste.add( clt.getName() );
        }
        return liste;
    }


     //// crud (ajouter , supprimer ,  modifier ) les donnees

    ///    ----- Client ----- ///
    @RequestMapping(value = "/Categorie_Client" ,method = RequestMethod.GET)
    public List<Categorie_Client> clients() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element> clients = l.get(1).getChildren();
        List<Categorie_Client> liste = new ArrayList<>();
        for (Element clt : clients) {

            liste.add(new Categorie_Client(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Client" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Client(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Client").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    @RequestMapping(value = "/Creer_Categorie_Client" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Client(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Client").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    //// ------ Fournisseur ----- ////
    @RequestMapping(value = "/Categorie_Fournisseur" ,method = RequestMethod.GET)
    public List<Categorie_Fournisseur> Fournisseurs() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element> clients = l.get(0).getChildren();
        List<Categorie_Fournisseur> liste = new ArrayList<>();
        for (Element clt : clients) {

            liste.add(new Categorie_Fournisseur(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Fournisseur" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Fournisseur(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Fournisseur").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Fournisseur" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Fournisseur(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Fournisseur").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    //// ------ Pays ----- ////
    @RequestMapping(value = "/Categorie_Pays" ,method = RequestMethod.GET)
    public List<Categorie_Pays> Categorie_Pays() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(7).getChildren();
        List<Categorie_Pays> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Pays(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Pays" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Pays(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Pays").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Pays" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Pays(@RequestParam String Categorie )
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie);

            root.getChild("Donnees").getChild("Categorie_Pays").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    //// ------ Ville ----- ////

    @RequestMapping(value = "/Categorie_Ville" ,method = RequestMethod.GET)
    public List<Categorie_Ville> Categorie_Ville( @RequestParam String Pays) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  Depots = l.get(8).getChildren();
        List<Categorie_Ville> liste = new ArrayList<>();
        for (Element clt : Depots) {

            if(Pays.equals(clt.getText())) {
                liste.add(new Categorie_Ville(clt.getName(), clt.getText()));
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Ville" ,method = RequestMethod.DELETE)
    public String  Supprimer_Ville(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Ville").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Ville" ,method = RequestMethod.POST)
    public String  Creer_Ville(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Ville").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    /// ------- Local ------////
    @RequestMapping(value = "/Categorie_Local" ,method = RequestMethod.GET)
    public List<Categorie_Local> Categorie_Local() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Locals = l.get(11).getChildren();
        List<Categorie_Local> liste = new ArrayList<>();
        for (Element clt : Locals) {

            liste.add(new Categorie_Local(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Local" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Local(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Local").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Local" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Local(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Local").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    //// ------ tva ----- ////
    @RequestMapping(value = "/Categorie_Tva" ,method = RequestMethod.GET)
    public List<Categorie_Tva> Categorie_Tva() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(9).getChildren();
        List<Categorie_Tva> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Tva(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Tva" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Tva(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Tva").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Tva" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Tva(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Tva").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    //// ------ NGP ----- ////
    @RequestMapping(value = "/Categorie_Ngp" ,method = RequestMethod.GET)
    public List<Categorie_Tva> Categorie_Ngp() {

        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(10).getChildren();
        List<Categorie_Tva> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Tva(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Ngp" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Ngp(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Ngp").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Ngp" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Ngp(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Ngp").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    /// ------- type1 ------////
    @RequestMapping(value = "/Categorie_Type1" ,method = RequestMethod.GET)
    public List<Categorie_Type1> Categorie_Type1() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  listchild = l.get(2).getChildren();
        List<Categorie_Type1> liste = new ArrayList<>();
        for (Element elm : listchild) {

            liste.add(new Categorie_Type1(elm.getName(),elm.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Type1" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Type1(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Type1").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Type1" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Type1(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Type1").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    //// ------ type2 ----- ////
    @RequestMapping(value = "/Categorie_Type2" ,method = RequestMethod.GET)
    public List<Categorie_Type1> Categorie_Type2(@RequestParam String Type ) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  listchild = l.get(3).getChildren();
        List<Categorie_Type1> liste = new ArrayList<>();
        for (Element elm : listchild) {
            if(Type.equals(elm.getText())) {
                liste.add(new Categorie_Type1(elm.getName(),elm.getText()));
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Type2" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Type2(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Type2").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Type2" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Type2(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Type2").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    /// ------- type3 ------////
    @RequestMapping(value = "/Categorie_Famille" ,method = RequestMethod.GET)
    public List<Categorie_Type1> Categorie_Type3(@RequestParam String Type ) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  listchild = l.get(4).getChildren();
        List<Categorie_Type1> liste = new ArrayList<>();
        for (Element elm : listchild) {
            if(Type.equals(elm.getText())) {
                liste.add(new Categorie_Type1(elm.getName(),elm.getText()));
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Famille" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Type3(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Famille").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Famille" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Type3(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Famille").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    /// ------- type4 ------////
    @RequestMapping(value = "/Categorie_Sous_Famille" ,method = RequestMethod.GET)
    public List<Categorie_Type1> Categorie_Type4(@RequestParam String Type ) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  listchild = l.get(5).getChildren();
        List<Categorie_Type1> liste = new ArrayList<>();
        for (Element elm : listchild) {
            if(Type.equals(elm.getText())) {
                liste.add(new Categorie_Type1(elm.getName(),elm.getText()));
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Sous_Famille" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Type4(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Sous_Famille").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Sous_Famille" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Type4(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Sous_Famille").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    /// ------- piece ------////
    @RequestMapping(value = "/Categorie_Piece" ,method = RequestMethod.GET)
    public List<Categorie_Piece> Categorie_Piece() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(12).getChildren();
        List<Categorie_Piece> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Piece(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Piece" ,method = RequestMethod.DELETE)
    public String  Supprimer_Piece(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Piece").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Piece" ,method = RequestMethod.POST)
    public String  Creer_Piece(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Piece").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }
    /// ------- region ------////
    @RequestMapping(value = "/Categorie_Region" ,method = RequestMethod.GET)
    public List<Categorie_Region> Categorie_Region(@RequestParam String Ville) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(6).getChildren();
        List<Categorie_Region> liste = new ArrayList<>();
        for (Element clt : Depots) {
            if(Ville.equals(clt.getText())) {
                liste.add(new Categorie_Region(clt.getName(), clt.getText()));
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Region" ,method = RequestMethod.DELETE)
    public String  Supprimer_Region(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Region").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Region" ,method = RequestMethod.POST)
    public String  Creer_Region(@RequestParam String Categorie , @RequestParam String Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Region").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    /// ------- Banque ------////
    @RequestMapping(value = "/Categorie_Banque" ,method = RequestMethod.GET)
    public List<Categorie_Piece> Banques() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(13).getChildren();
        List<Categorie_Piece> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Piece(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Banque" ,method = RequestMethod.DELETE)
    public String  Supprimer_Banque(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Banque").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Banque" ,method = RequestMethod.POST)
    public String  Creer_Banque(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Banque").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    /// ------- Categorie_Fiscale ------////
    @RequestMapping(value = "/Categorie_Fiscale" ,method = RequestMethod.GET)
    public List<Categorie_Piece> Categorie_Fiscale() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(14).getChildren();
        List<Categorie_Piece> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Piece(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Fiscale" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Fiscale(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Fiscale").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Fiscale" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Fiscale(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Fiscale").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    /// ------- Categorie_Type_Paiement------////
    @RequestMapping(value = "/Categorie_Type_Paiement" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Paiement() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(15).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Type_Paiement" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Paiement(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Type_Paiement").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Type_Paiement" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Paiement(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Type_Paiement").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    /// ------- Categorie_Unite------////
    @RequestMapping(value = "/Categorie_Unite" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Unite() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(16).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Unite" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Unite(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Unite").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Unite" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Unite(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Unite").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    /// ------- Categorie_Fodec------////
    @RequestMapping(value = "/Categorie_Fodec" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Fodec() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(17).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Fodec" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Fodec(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Fodec").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Fodec" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Fodec(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Fodec").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    @RequestMapping(value = "/Categorie_Employe" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Employe() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(18).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Employe" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Employe(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Employe").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Employe" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Employe(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Employe").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Categorie_Conge" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Conge() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(19).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Conge" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Conge(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Conge").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Conge" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Conge(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Conge").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    @RequestMapping(value = "/Categorie_Taxe" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Taxe() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(20).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Taxe" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Taxe(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Taxe").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Taxe" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Taxe(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Taxe").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }



    @RequestMapping(value = "/Categorie_Agence_Transitaire" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Agence_Transitaire() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(21).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Agence_Transitaire" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Agence_Transitaire(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Agence_Transitaire").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Agence_Transitaire" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Agence_Transitaire(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Agence_Transitaire").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


    @RequestMapping(value = "/Categorie_Agence_Transport" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Agence_Transport() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(22).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Agence_Transport" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Agence_Transport(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Agence_Transport").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Agence_Transport" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Agence_Transport(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Agence_Transport").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }






    @RequestMapping(value = "/Liste_Taxe_Ngp" ,method = RequestMethod.GET)
    public List<String> Liste_Taxe_Ngp(@RequestParam  String NGP) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  Depots = l.get(10).getChildren();
        List<String> liste = new ArrayList<>();
        for (Element clt : Depots) {
             if(NGP.equals(clt.getName())) {
                for (Element clt2 : clt.getChildren()) {
                    liste.add(clt2.getName());
                }
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Liste_Taxe_Ngp" ,method = RequestMethod.DELETE)
    public String  Supprimer_Liste_Taxe_Ngp(@RequestParam String NGP , @RequestParam String Taxe)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Ngp").getChild(NGP).removeChild(Taxe);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Liste_Taxe_Ngp" ,method = RequestMethod.POST)
    public String  Creer_Liste_Taxe_Ngp(@RequestParam String NGP , @RequestParam String Taxe)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Taxe);

            root.getChild("Donnees").getChild("Categorie_Ngp").getChild(NGP).addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }




    @RequestMapping(value = "/Categorie_Famille_Logistique" ,method = RequestMethod.GET)
    public List<Categorie_Paiement> Categorie_Famille_Logistique() {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();

        List<Element>  Depots = l.get(23).getChildren();
        List<Categorie_Paiement> liste = new ArrayList<>();
        for (Element clt : Depots) {

            liste.add(new Categorie_Paiement(clt.getName(),clt.getText()));
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Categorie_Famille_Logistique" ,method = RequestMethod.DELETE)
    public String  Supprimer_Categorie_Famille_Logistique(@RequestParam String Categorie)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Famille_Logistique").removeChild(Categorie);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Categorie_Famille_Logistique" ,method = RequestMethod.POST)
    public String  Creer_Categorie_Famille_Logistique(@RequestParam String Categorie , @RequestParam double Valeur)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Categorie); el.setText(Valeur+"");

            root.getChild("Donnees").getChild("Categorie_Famille_Logistique").addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }



    @RequestMapping(value = "/Categorie_Sous_Famille_Logistique" ,method = RequestMethod.GET)
    public List<String> Categorie_Sous_Famille_Logistique(@RequestParam  String Famille_Logistique) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        try {
            document = saxBuilder.build(new File("./src/Donnnee.xml"));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Namespace ns = root.getNamespace();
        Element DataSets = document.getRootElement();
        Element be = DataSets.getChild("Donnees");
        List<Element> l = be.getChildren();
        List<Element>  Depots = l.get(23).getChildren();
        List<String> liste = new ArrayList<>();
        for (Element clt : Depots) {
            if(Famille_Logistique.equals(clt.getName())) {
                for (Element clt2 : clt.getChildren()) {
                    liste.add(clt2.getName());
                }
            }
        }
        return liste;
    }

    @RequestMapping(value = "/Supprimer_Sous_Famille_Logistique" ,method = RequestMethod.DELETE)
    public String  Supprimer_Sous_Famille_Logistique(@RequestParam String Famille_Logistique , @RequestParam String Sous_Famille_Logistique)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            root.getChild("Donnees").getChild("Categorie_Famille_Logistique").getChild(Famille_Logistique).removeChild(Sous_Famille_Logistique);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }

    @RequestMapping(value = "/Creer_Sous_Famille_Logistique" ,method = RequestMethod.POST)
    public String  Creer_Sous_Famille_Logistique(@RequestParam String Famille_Logistique , @RequestParam String Sous_Famille_Logistique)
    {
        SAXBuilder builder = new SAXBuilder();
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            Document doc = builder.build(new File("./src/Donnnee.xml"));
            Element root = doc.getRootElement();
            Element el = new Element (Sous_Famille_Logistique);

            root.getChild("Donnees").getChild("Famille_Logistique").getChild(Famille_Logistique).addContent(el);
            sortie.output(doc, new FileOutputStream("./src/Donnnee.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok" ;
    }


}

package oc.wh40k.units.or;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORHeizakultKammerWaaaghboss extends RuestkammerVater {

	OptionsEinzelUpgrade waaaghboss;
	OptionsUpgradeGruppe bossCC;
    OptionsUpgradeGruppe bossFK;
    OptionsUpgradeGruppe bossMegaBike;
    OptionsEinzelUpgrade munigrot;
    OptionsEinzelUpgrade schnappasquik;
    OptionsEinzelUpgrade cyborgK�rpa;
    OptionsEinzelUpgrade troph�enstange;
    OptionsEinzelUpgrade panzar�stung;
    boolean megar�stungBild = false;
	OptionsEinzelUpgrade madDokCybork;

	public ORHeizakultKammerWaaaghboss() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		name = "Waaaghboss";

        add(ico = new oc.Picture("oc/wh40k/images/Waaghboss.gif"));
        

        waaaghboss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Waaaghboss", 60);
        add(waaaghboss);
        
        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiekrall�", 25));

        bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossCC);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Wumme", 5));

        bossFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossFK);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Megar�stung", 40));
        ogE.addElement(new OptionsGruppeEintrag("Waaghbike", 40));

        bossMegaBike = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossMegaBike);

        seperator();

        munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Munigrot", 3);
        add(munigrot);

        schnappasquik = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schnappasquik", 15);
        add(schnappasquik);

        cyborgK�rpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork-K�rpa", 10);
        add(cyborgK�rpa);

        troph�enstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Troph�'enstang�", 5);
        add(troph�enstange);

        panzar�stung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzar�stung", 5);
        add(panzar�stung);
        
        seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-K�rpa", 5));


        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Gargbosse");
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bosse");
        BuildaHQ.addToInformationVector("ORWaaghboss", 1);

		sizeSetzen();
	}

	@Override
    public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgef�hrt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt
        BuildaHQ.addToInformationVector("ORWaaghboss", -1);
        if (BuildaHQ.getCountFromInformationVector("ORWaaghboss") <= 0) {
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Gargbosse");
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Bosse");
        }
        super.deleteYourself();
    }

    @Override
    public void refreshen() {
    	
    	waaaghboss.setSelected(true);
    	
        if (bossMegaBike.getCurrentName().equals("Megar�stung")) {
            bossCC.setAktiv(false);
            bossFK.setAktiv(false);

            if (megar�stungBild == false) {
                String icon = "oc/wh40k/images/WaaaghbossMegaruestung.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                megar�stungBild = true;
            }
        } else {
            bossCC.setAktiv(true);
            bossFK.setAktiv(true);

            if (megar�stungBild == true) {
                String icon = "oc/wh40k/images/Waaghboss.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                megar�stungBild = false;
            }
        }

        panzar�stung.setAktiv(!bossMegaBike.isSelected());
        
        if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !cyborgK�rpa.isSelected()){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
        
        if(madDokCybork.isSelected()){
        	cyborgK�rpa.setAktiv(false);
		} else {
			cyborgK�rpa.setAktiv(true);
		}
    }

}

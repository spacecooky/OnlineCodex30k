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
    OptionsEinzelUpgrade cyborgKörpa;
    OptionsEinzelUpgrade trophäenstange;
    OptionsEinzelUpgrade panzarüstung;
    boolean megarüstungBild = false;
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
        ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));

        bossCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossCC);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Wumme", 5));

        bossFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossFK);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Megarüstung", 40));
        ogE.addElement(new OptionsGruppeEintrag("Waaghbike", 40));

        bossMegaBike = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(bossMegaBike);

        seperator();

        munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Munigrot", 3);
        add(munigrot);

        schnappasquik = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schnappasquik", 15);
        add(schnappasquik);

        cyborgKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork-Körpa", 10);
        add(cyborgKörpa);

        trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Trophä'enstangä", 5);
        add(trophäenstange);

        panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzarüstung", 5);
        add(panzarüstung);
        
        seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", 5));


        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Gargbosse");
        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bosse");
        BuildaHQ.addToInformationVector("ORWaaghboss", 1);

		sizeSetzen();
	}

	@Override
    public void deleteYourself() {  // WICHTIG: wird nicht beim Volkwechseln ausgeführt. Dafr wird BuildaHQ.leereChooserGruppenArray(); aufgerufen, was das ersetzt
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
    	
        if (bossMegaBike.getCurrentName().equals("Megarüstung")) {
            bossCC.setAktiv(false);
            bossFK.setAktiv(false);

            if (megarüstungBild == false) {
                String icon = "oc/wh40k/images/WaaaghbossMegaruestung.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                megarüstungBild = true;
            }
        } else {
            bossCC.setAktiv(true);
            bossFK.setAktiv(true);

            if (megarüstungBild == true) {
                String icon = "oc/wh40k/images/Waaghboss.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                megarüstungBild = false;
            }
        }

        panzarüstung.setAktiv(!bossMegaBike.isSelected());
        
        if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !cyborgKörpa.isSelected()){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
        
        if(madDokCybork.isSelected()){
        	cyborgKörpa.setAktiv(false);
		} else {
			cyborgKörpa.setAktiv(true);
		}
    }

}

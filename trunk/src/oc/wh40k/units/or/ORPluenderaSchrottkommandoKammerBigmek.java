package oc.wh40k.units.or;

import javax.swing.ImageIcon;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORPluenderaSchrottkommandoKammerBigmek extends RuestkammerVater {

	OptionsEinzelUpgrade bigmek;
	OptionsEinzelUpgrade Munigrot;
    OptionsEinzelUpgrade CyborkKörpa;
    OptionsEinzelUpgrade Panzarüstung;
    OptionsEinzelUpgrade Trophäenstange;
    OptionsEinzelUpgrade Schnappasquik;
    OptionsUpgradeGruppe BigmekCC;
    OptionsUpgradeGruppe BigmekFK;
    OptionsEinzelZaehler Schmiergrot;
	OptionsEinzelUpgrade madDokCybork;

	public ORPluenderaSchrottkommandoKammerBigmek() {
	}

	public void initButtons(boolean... defaults) {
		name = "Bigmek";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));
        

        bigmek = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bigmek", 35);
        add(bigmek);
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Brenna", 20));
        ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));

        BigmekCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(BigmekCC);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Megablasta", 15));
        ogE.addElement(new OptionsGruppeEintrag("Megarüstung", 40));
        ogE.addElement(new OptionsGruppeEintrag("Snotzogga", 60));
        ogE.addElement(new OptionsGruppeEintrag("Schpezialkraftfeld", 50));
        ogE.addElement(new OptionsGruppeEintrag("Waaghbike", 40));

        BigmekFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(BigmekFK);

        seperator(15);

        Munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Munigrot", 3);
        add(Munigrot);

        CyborkKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork-Körpa", 10);
        add(CyborkKörpa);

        Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzarüstung", 5);
        add(Panzarüstung);

        Trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Trophäenstange", 5);
        add(Trophäenstange);

        Schnappasquik = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schnappasquik", 15);
        add(Schnappasquik);

        seperator();

        Schmiergrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Schmiergrot", 3, 5);
        add(Schmiergrot);

        seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", 5));

        seperator();

        BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Gargbot");
        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("[Imperial Armour] Grot Tank Battle Mob");
        BuildaHQ.addToInformationVector("ORBigmek", 1);

		sizeSetzen();
	}

	 @Override
	    public void deleteYourself() {
	        BuildaHQ.addToInformationVector("ORBigmek", -1);
	        if(BuildaHQ.getCountFromInformationVector("ORBigmek") <= 0) {
	            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Gargbot");
	            BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("[Imperial Armour] Grot Tank Battle Mob");
	        }
	        super.deleteYourself();
	    }

	    int aktivesBild = 0;

	    //@OVERRIDE
	    @Override
	    public void refreshen() {
	    	
	    	bigmek.setSelected(true);
	    	
	        BigmekFK.setAktiv("Megarüstung", !BigmekFK.isSelected("Waaghbike"));

	        if (BigmekFK.getCurrentName().equals("Schpezialkraftfeld")) {
	            if (aktivesBild != 1) {
	                String icon = "oc/wh40k/images/BigmekKraftfeld.gif";
	                ico.setIcon(icon);

	                try {
	                    ico.updateSize();
	                } catch (Exception e) {
	                }

	                aktivesBild = 1;
	            }
	        } else if (BigmekFK.getCurrentName().equals("Snotzogga")) {
	            if (aktivesBild != 2) {
	                String icon = "oc/wh40k/images/BigmekSnotzogga.gif";
	                ico.setIcon(icon);

	                try {
	                    ico.updateSize();
	                } catch (Exception e) {
	                }

	                aktivesBild = 2;
	            }
	        } else {
	            if (aktivesBild != 0) {
	                String icon = "oc/wh40k/images/Bigmek.gif";

	                ico.setIcon(icon);

	                try {
	                    ico.updateSize();
	                } catch (Exception e) {
	                }

	                aktivesBild = 0;
	            }
	        }
	        
	        if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !CyborkKörpa.isSelected()){
				madDokCybork.setAktiv(true);
				
			} else {
				madDokCybork.setAktiv(false);
				madDokCybork.setSelected(false);
			}
	        
	        if(madDokCybork.isSelected()){
				CyborkKörpa.setAktiv(false);
			} else {
				CyborkKörpa.setAktiv(true);
			}
	    }

}

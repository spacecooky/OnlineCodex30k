package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TAKrootJagdtrupp extends Eintrag {

	AnzahlPanel Kroot;
	AnzahlPanel Kroothunde;
	AnzahlPanel Krootoxe;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;

	public TAKrootJagdtrupp() {
		name = "Kroot Jagdtrupp";
		grundkosten = 0;

		add(Kroot = new AnzahlPanel(ID, randAbstand, cnt, "Kroot", 10, 20, 7));
		add(Kroothunde = new AnzahlPanel(ID, randAbstand, cnt, "Kroothund", "Kroothunde", 0, 12, 6));
		add(Krootoxe = new AnzahlPanel(ID, randAbstand, cnt, "Krootox", "Krootoxe", 0, 3, 35));

        Kroothunde.setNichtDieErsteOption(true);
		Krootoxe.setNichtDieErsteOption(true);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/KrootJagdtrupp.gif"));
		

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "6+ Rüstungswurf", 1, 10));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TAKrootWeiser", "Upgrade zum Kroot-Weisen");
		rkBoss.initKammer(true, true, true);
		add(rkBoss);
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("[Forgeworld] Great Knarloc Baggage Herd");
        BuildaHQ.addToInformationVector("TAKroots", 1);

		complete();
	}

	@Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("TAKroots", -1);
        if(BuildaHQ.getCountFromInformationVector("TAKroots") <= 0) {
            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("[Forgeworld] Great Knarloc Baggage Herd");
        }
        super.deleteYourself();
    }
	
	@Override
	public void refreshen() {
		oe1.setAktiv(rkBoss.isSelected());

		oe1.setModelle(Kroot.getModelle() + Kroothunde.getModelle() + Krootoxe.getModelle() - 1);
        
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        
        if(BuildaHQ.getCountFromInformationVector("TAFeuerkrieger") < 1) {
        	setFehlermeldung("1+ Feuerkrieger");
        } else if(oshova){
        	setFehlermeldung("Nicht erlaubt!");
        }
        else {
        	setFehlermeldung("");
        }
	}

}

package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class TAKrootJagdtruppKammer extends RuestkammerVater {

	AnzahlPanel Kroot;
	AnzahlPanel Kroothunde;
	AnzahlPanel Krootoxe;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBoss2;
	
	OptionsEinzelUpgrade kopf;
	OptionsEinzelUpgrade schleicher;
	OptionsEinzelUpgrade geier;
	OptionsEinzelUpgrade schützen;
	OptionsEinzelUpgrade hyper;

	public TAKrootJagdtruppKammer() {
		name = "Kroot Jagdtrupp";
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {	
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
		
		rkBoss2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKrootWeiser", "Upgrade zum Kroot-Ältesten");
		rkBoss2.initKammer(true, true, true);
		add(rkBoss2);
		
		seperator();
		
		add(kopf = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Kopfjägersippe",50));
		add(schleicher = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Schleichersippe",50));
		add(geier = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Geiersippe",50));
		add(schützen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Schützensippe",20));
		add(hyper = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Hyperaktive Nymunenadaption",20));
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("[Forgeworld] Great Knarloc Baggage Herd");
        BuildaHQ.addToInformationVector("TAKroots", 1);

		sizeSetzen();
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
		oe1.setAktiv(rkBoss.isSelected() || rkBoss2.isSelected());
		rkBoss.setAktiv(!rkBoss2.isSelected());
		rkBoss2.setAktiv(!rkBoss.isSelected());

		oe1.setModelle(Kroot.getModelle() + Kroothunde.getModelle() + Krootoxe.getModelle() - 1);
        
		kopf.setAktiv(Kroothunde.getModelle()==0 && Krootoxe.getModelle()==0);
		schleicher.setAktiv(Krootoxe.getModelle()==0);
		geier.setAktiv(Kroothunde.getModelle()==0 && Krootoxe.getModelle()==0);
		hyper.setAktiv(Krootoxe.getModelle()==0);
	}

}

package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionVeteranTacticalSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2, o4;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionVeteranTacticalSquad() {
		name = "Legion Veteran Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 5, 10, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		ogE.addElement(new OptionsGruppeEintrag("Chem-Munitions", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 25));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher (+flakk)", 35));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Veteran Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Dedicated transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        o3.setAktiv(3, o1.isSelected("Heavy flamer"));
        
		o2.setMaxAnzahl(squad.getModelle() - 1); // die 1 ist für den sarge
		o4.setMaxAnzahl(squad.getModelle() - 1);
		o1.setMaxAnzahl(squad.getModelle() / 5);
		
		rkTransport.getPanel().setLocation(
				(int) rkTransport.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
	    );
	}

}

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
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;
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
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
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
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 25));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher (+flakk)", 35));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGVeteranSergeant", "Veteran Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(true, true, true, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGRhinoKammer", "Rhino");
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Legion Rhino Armoured Carrier");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o2.setMaxAnzahl(squad.getModelle() - 1); // die 1 ist für den sarge
		o4.setMaxAnzahl(squad.getModelle() - 1);
		o1.setMaxAnzahl(squad.getModelle() / 5);
	}

}

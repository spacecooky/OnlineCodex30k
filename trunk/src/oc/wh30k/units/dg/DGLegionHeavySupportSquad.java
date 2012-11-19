package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionHeavySupportSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1, o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionHeavySupportSquad() {
		name = "Legion Heavy Support Squad\n";
		grundkosten = 35;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 20);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hardened armour", 25));
		ogE.addElement(new OptionsGruppeEintrag("Flakk missiles", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Auto-cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Culverin", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(true, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, false, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        if(!o2.isSelected()) o2.setSelected(0, true);
        
        o1.setAktiv(1, o2.isSelected("Missile launcher"));
        
        o2.setPreis(2, (squad.getModelle()-1) * 5);
        o2.setPreis(3, (squad.getModelle()-1) * 5);
        o2.setPreis(4, (squad.getModelle()-1) * 10);
        o2.setPreis(5, (squad.getModelle()-1) * 15);
        o2.setPreis(6, (squad.getModelle()-1) * 10);
        o2.setPreis(7, (squad.getModelle()-1) * 20);
	}

}

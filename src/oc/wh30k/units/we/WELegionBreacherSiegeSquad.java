package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionBreacherSiegeSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransportPhobos;

	public WELegionBreacherSiegeSquad() {
		name = "Legion Breacher Siege Squad\n";
		grundkosten = 125;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 10, 20, 10);
		add(squad);

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 15));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Melta gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Graviton gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Lascutter", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, false, true, false, false, false, false, false, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();
		rkTransportPhobos = new RuestkammerStarter(ID, randAbstand, cnt, "SHTransportKammerPhobos", "Legion Land Raider Phobos\n");
		rkTransportPhobos.initKammer();
		rkTransportPhobos.setButtonText("Legion Land Raider Phobos");
		add(rkTransportPhobos);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        rkTransportPhobos.setAktiv(squad.getModelle() <=10);
        
        o1.setPreis(2, squad.getModelle() * 5);
        o2.setMaxAnzahl(squad.getModelle() / 5);
        
        rkTransportPhobos.getPanel().setLocation(
				(int) rkTransportPhobos.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
	    );
	}

}

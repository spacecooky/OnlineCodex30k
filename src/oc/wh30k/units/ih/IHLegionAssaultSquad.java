package oc.wh30k.units.ih;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IHLegionAssaultSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;

	public IHLegionAssaultSquad() {
		name = "Legion Assault Squad\n";
		grundkosten = 100;
		überschriftSetzen = true;
		
		BuildaHQ.addToInformationVector("IHJump", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Assault Marine", 10, 20, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Combat shields", 3));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "IHSergeant", "Assault Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reaver, Reco, Seeker, Support, Tactical, Terminator, Veteran
		rkBoss.initKammer(true, false, false, false, false, false, false, false, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
                
        o1.setPreis(0, squad.getModelle() * 5);
        o1.setPreis(1, squad.getModelle() * 3);
		o2.setMaxAnzahl(squad.getModelle() / 5);
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("IHJump");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("IHInfantry");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Rigid Tactics!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("IHJump", -1);
	}
}

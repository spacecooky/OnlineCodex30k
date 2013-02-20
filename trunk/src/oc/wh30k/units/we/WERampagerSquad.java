package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WERampagerSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o2, o4, o7a, o7aStandard, o7b, o7bStandard, o7c, o8;
	OptionsUpgradeGruppe o1, o3;
	OptionsZaehlerGruppe o7aStandard2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public WERampagerSquad() {
		name = "Rampager Squad\n";
		grundkosten = 30;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rampagers", 5, 10, 20);
		add(squad);
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Jump packs", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Chainaxe"), 0));
		add(o7aStandard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));		
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 5));
		add(o7a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Barb-hook lash", 10));
		ogE.addElement(new OptionsGruppeEintrag("Excoriator chainaxe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meteor hammer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Twin Falax blades", 10));
		add(o7c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Rampager Champion");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, false, false, false, false, false, false, false, false, false, false, true);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "WETransporterKammer", "Transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(false, false, false, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
        int subtractor = 1; // boss
		int nksubractor=(o7a.getAnzahl());
        
        o7a.setMaxAnzahl(squad.getModelle()-subtractor-o7c.getAnzahl());
		
		o7aStandard.setMaxAnzahl(squad.getModelle()-subtractor-o7a.getAnzahl()-o7c.getAnzahl());
		o7aStandard.setAnzahl(0,o7aStandard.getMaxAnzahl());
				
		o7c.setMaxAnzahl(squad.getModelle()-subtractor-nksubractor);
		
		rkTransport.setAktiv(!o1.isSelected());
		
		o1.setPreis(0, squad.getModelle()*10);
		
		
		rkTransport.getPanel().setLocation(
				(int) rkTransport.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
	    );
		
		
	}

}

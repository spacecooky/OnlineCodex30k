package oc.wh30k.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WELegionReconnaissanceSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o2Standard;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public WELegionReconnaissanceSquad() {
		name = "Legion Reconnaissance Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chameleoline", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		ogE.addElement(new OptionsGruppeEintrag("Recon armour", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(o2Standard = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
		ogE.addElement(new OptionsGruppeEintrag("Chainaxe", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "WESergeant", "Legion Sergeant");
		rkBoss.setGrundkosten(0);
		//Assault, Bike, Breacher, Destroyer, Heavy, Reco, Seeker, Support, Tactical, Terminator, Veteran, Rampager
		rkBoss.initKammer(false, false, false, false, false, true, false, false, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "WETransporterKammer", "Transport");
		//Rhino, Pod, Dreadclaw, Phobos, Spartan
		rkTransport.initKammer(true, true, false, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setPreis(1, squad.getModelle()*5);
		o1.setPreis(2, squad.getModelle()*5);

		int subtractor = 1; // boss        
        o2.setMaxAnzahl(squad.getModelle()-subtractor);
        o2Standard.setMaxAnzahl(squad.getModelle()-subtractor-o2.getAnzahl());
		o2Standard.setAnzahl(0,o2Standard.getMaxAnzahl());
		
		rkTransport.getPanel().setLocation(
				(int) rkTransport.getPanel().getLocation().getX(),
				(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
	    );
	}

}

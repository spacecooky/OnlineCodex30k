package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionSeekerSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionSeekerSquad() {
		name = "Legion Seeker Squad\n";
		grundkosten = 100;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		ogE.addElement(new OptionsGruppeEintrag("Combi-weapon", 10));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

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
        
        int subtractor = 1; // boss
		 
        o3.setMaxAnzahl(squad.getModelle()-subtractor);
		
		o2.setMaxAnzahl(squad.getModelle()-subtractor-o3.getAnzahl());
		o2.setAnzahl(0, o3.getMaxAnzahl()-o3.getAnzahl());
	}

}

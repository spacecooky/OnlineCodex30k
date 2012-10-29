package oc.wh30k.units.dg;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGLegionDestroyerSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsZaehlerGruppe o4;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGLegionDestroyerSquad() {
		name = "Legion Destroyer Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Destroyer Marines", 5, 10, 20);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 25));
		ogE.addElement(new OptionsGruppeEintrag("Jump packs", 75));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Missile launcher (rad)", 25));
		ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
		ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DGSergeant", "Destroyer Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(false, true, false);
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
        if(!rkBoss.isSelected()) {rkBoss.setSelected(true);}        
       
        if(o3.isSelected("Jump packs")) {
        	rkTransport.setAktiv(false);
        } else {
        	rkTransport.setAktiv(true);
        }
        
		o1.setMaxAnzahl(squad.getModelle() / 5);
	}

}

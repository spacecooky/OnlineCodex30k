package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ECLegionTacticalSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o5;
	OptionsUpgradeGruppe o1, o2, o3, o4;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	

	public ECLegionTacticalSquad() {
		name = "Legion Tactical Squad\n";
		grundkosten = 50;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 10, 20, 10);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Legion Vexilla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nuncio-vox", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolters", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		ogE.addElement(new OptionsGruppeEintrag("Additional chainswords", 2));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chainswords", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECSergeant", "Tactical Sergeant");
		rkBoss.setGrundkosten(0);
		rkBoss.initKammer(true, false, false, false, false);
		rkBoss.setAbwaehlbar(false);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ECTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(true, false, false, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);
		

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        if(o2.isSelected()) {
        		o4.setAktiv(false); // keine kostenlosen chainswords wenn bolter gewählt sind
        	}
        	else {
        		o4.setAktiv(true);
        	}
        if(o4.isSelected()) {
        	o3.setAktiv(false); // keine kostenpflichtigen ccw wenn BP&CCW gewählt
        	o2.setAktiv(false); // keine bolter mehr bei BP&CCW
        } else {
        	o3.setAktiv(true);
        	o2.setAktiv(true);
        }
        
        
        rkTransport.setAktiv(squad.getModelle() <=10);
        //o2.setAktiv(!o4.isSelected());
        //o3.setAktiv(!o2.isSelected(1));
        
        o3.setPreis(0, squad.getModelle() * 2);
        
		
	}

}

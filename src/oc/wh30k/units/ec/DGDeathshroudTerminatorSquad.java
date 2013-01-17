package oc.wh30k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DGDeathshroudTerminatorSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o5;
	OptionsUpgradeGruppe o1, o2, o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;

	public DGDeathshroudTerminatorSquad() {
		name = "Deathshroud Terminator Squad\n";
		grundkosten = 10;
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("DGLegionCommandSquad", 1);
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Deathshroud Terminators", 2, 10, 40);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DGTransporterKammer", "Transport");
		//Rhino, Pod, Phobos, Spartan
		rkTransport.initKammer(false, false, true, false);
		rkTransport.setButtonText("Dedicated transport");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        
        rkTransport.setAktiv(squad.getModelle() <=5);
        
        o1.setPreis(0, squad.getModelle() * 5);
        
        int selectedSquads = BuildaHQ.getCountFromInformationVector("DGLegionCommandSquad");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("DGPraetor");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Command Squads > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("DGLegionCommandSquad", -1);
		super.deleteYourself();
	}

}

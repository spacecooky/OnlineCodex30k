package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class TLTerminatorSturmtrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	RuestkammerStarter rkRaider;

	boolean raiderSelected = false;

	public TLTerminatorSturmtrupp() {
		name = "Terminator-Sturmtrupp\n";
		grundkosten = 0;
		überschriftSetzen = true;
		
		BuildaHQ.addToInformationVector("TLElite", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sturm-Terminatoren", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTerminatorSturmtrupp.jpg"));

		seperator(12);

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "E-Hammer & Schild", "Energiehammer und Sturmschild", -88, 0));

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "TLLandRaiderKammer", "Land Raider");
		rkRaider.initKammer(false);
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());

		// Unique entry: Land Raider
		boolean raiderGlobal = ( BuildaHQ.getCountFromInformationVector("TLAssaultTermiRaider") > 0 ? true : false );
		if(raiderGlobal && !raiderSelected) rkRaider.setAktiv(false);
		else rkRaider.setAktiv(true);

		if(rkRaider.isSelected()) {
			raiderSelected = true;
			BuildaHQ.addToInformationVector("TLAssaultTermiRaider", 1);
		} else {
			if(raiderSelected) {
				raiderSelected = false;
				BuildaHQ.setInformationVectorValue("TLAssaultTermiRaider", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLElite");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Eliteauswahlen > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		if(raiderSelected) {
			BuildaHQ.setInformationVectorValue("TLAssaultTermiRaider", 0);
		}
		BuildaHQ.addToInformationVector("TLElite", -1);
		super.deleteYourself();
	}

}

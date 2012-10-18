package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IGLemanRussSchwadron extends Eintrag {

	OptionsEinzelUpgrade oe1;
	RuestkammerStarter t1;
	RuestkammerStarter t2;
	RuestkammerStarter t3;

	private boolean isDemonHunters = false;
	private boolean isWitchHunters = false;

	public IGLemanRussSchwadron() {
		name = "Leman-Russ-Schwadron";
		grundkosten = 0;
		this.überschriftSetzen = true;

		checkDraftOption();

		add(ico = new oc.Picture("oc/wh40k/images/IGLemanRussSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnnetze", 20));

		seperator();

		t1 = new RuestkammerStarter(ID, randAbstand, cnt, "IGLemanRuss", "", 1);
		t1.initKammer();
		t1.setButtonText("Kampfpanzer 1");
		add(t1);

		seperator();

		t2 = new RuestkammerStarter(ID, randAbstand, cnt, "IGLemanRuss", "", 1);
		t2.initKammer();
		t2.setButtonText("Kampfpanzer 2");
		add(t2);

		seperator();

		t3 = new RuestkammerStarter(ID, randAbstand, cnt, "IGLemanRuss", "", 1);
		t3.initKammer();
		t3.setButtonText("Kampfpanzer 3");
		add(t3);

		complete();
	}

	@Override
	public void refreshen() {
		int tanks = (t1.isSelected() ? 1 : 0) + (t2.isSelected() ? 1 : 0) + (t3.isSelected() ? 1 : 0);

		oe1.setPreis(tanks * 20);
		oe1.setAktiv(tanks > 0);

		// Check validity in case of drafted units for Inquisition amries
		if(isDemonHunters || isWitchHunters) {
			int draftTroops = BuildaHQ.getCountFromInformationVector( isDemonHunters ? "DJDraftTroops" : "HXDraftTroops" );
			int choice = BuildaHQ.getCountFromInformationVector("IGLemanRussSquadron");
			if(draftTroops < 2) {
				setFehlermeldung("Zu wenig IA-Standards!");
			}
			else {
				if(choice > 1) {
					setFehlermeldung("0-1 Auswahl");
				} else {
					setFehlermeldung("");
				}
			}
		}
	}

	private void checkDraftOption() {
		isDemonHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Daemonenjaeger");
		isWitchHunters = OnlineCodex.getInstance().getCurrentArmy().equals("Hexenjaeger");

		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGLemanRussSquadron", 1);
		}
	}

	@Override
	public void deleteYourself() {
		if(isDemonHunters || isWitchHunters) {
			BuildaHQ.addToInformationVector("IGLemanRussSquadron", -1);
		}
		super.deleteYourself();
	}

}

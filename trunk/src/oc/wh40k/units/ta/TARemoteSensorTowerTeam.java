package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TARemoteSensorTowerTeam extends Eintrag {

	AnzahlPanel squad;

	public TARemoteSensorTowerTeam() {
		name = "Remote Sensor Tower Team";
		grundkosten = 0;
		setCountToMinimum(false);
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Remote Sensor Tower", "Remote Sensor Towers", 1, 3, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));
		
        
        seperator();

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        
        if(BuildaHQ.getCountFromInformationVector("TAFeuerkrieger") < 1) {
        	setFehlermeldung("1+ Feuerkrieger");
        } else {
        	setFehlermeldung("");
        }
	}
}

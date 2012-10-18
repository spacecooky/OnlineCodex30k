package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class EMStachelsalamanderJagdrudel extends Eintrag {

	AnzahlPanel squad;
	AnzahlPanel squad2;
	
	public EMStachelsalamanderJagdrudel() {
		name = BuildaHQ.translate("Stachelsalamander");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Stachelsalamander"), 1, 3, 75);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
				
        squad2 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Skink-Treiber"), 0, 1, 5);
		squad2.setGrundkosten(0);
        squad2.setNichtDieErsteOption(true);
		add(squad2);
		
		add(ico = new oc.Picture("oc/images/EMStachelsalamanderJagdrudel.jpg"));
		
		complete();
	}

	@Override
	public void refreshen() {
		squad2.setMaxModelle(squad.getModelle());
	}
}

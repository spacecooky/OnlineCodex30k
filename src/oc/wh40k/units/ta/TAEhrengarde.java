package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class TAEhrengarde extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkRochen;

	public TAEhrengarde() {
		name = "Ehrengarde";
		grundkosten = 0;
		this.setEintragsCNT(0);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Ehrengardisten", 6, 12, 12);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/Ehrengarde.gif"));
		

		seperator();

		o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmgewehre", "Pulssturmgewehre", squad.getModelle(), 0);
		add(o1);

		seperator(8);

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Photonengranaten", 1));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "EMP-Granaten", 3));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TAInfanterieKammer", "Shas'ui");
		rkBoss.initKammer(true, true);
		add(rkBoss);

		seperator();

		rkRochen = new RuestkammerStarter(ID, randAbstand, cnt, "TATeufelsrochenKammer", "Teufelsrochen");
		rkRochen.initKammer();
		add(rkRochen);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());

		int empPrice = squad.getModelle() * 3;
		if(rkBoss.isSelected() && rkBoss.getKammer().getSpecialValue().equals("TRUE")) {
			empPrice = empPrice - 3;
		}
		o3.setPreis(empPrice);
		o2.setPreis(squad.getModelle() * 1);

		rkRochen.getPanel().setLocation(
			(int) rkRochen.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}

}

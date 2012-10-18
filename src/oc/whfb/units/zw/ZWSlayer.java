package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class ZWSlayer extends Eintrag {

	protected AnzahlPanel squad;
	public OptionsEinzelUpgrade oeM;
	public OptionsEinzelUpgrade oeS;
	public OptionsEinzelZaehler oeC;
	RuestkammerStarter rkStandarte;
	
	public ZWSlayer() {
		name = BuildaHQ.translate("Slayer");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Slayer"), 5, 30, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWSlayer.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", BuildaHQ.translate("Riesenslayer"), squad.getModelle(), 15));

		complete();

	}

	@Override
	public void refreshen() {
		oeC.setMaxAnzahl(squad.getModelle());	
	}
}

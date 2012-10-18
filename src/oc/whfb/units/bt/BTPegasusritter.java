package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.whfb.armies.VOLKBretonia;

public class BTPegasusritter extends Eintrag {

	AnzahlPanel squad;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	boolean set = false;
	RuestkammerStarter rkBanner;

	public BTPegasusritter() {
		name = BuildaHQ.translate("Pegasusritter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Pegasusritter"), 3, 10, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));

		complete();
	}

	@Override
	public void refreshen() {
		boolean pegasus = ( BuildaHQ.getCountFromInformationVector("BT_PEGGIE") > 0 ? true : false );
		if(VOLKBretonia.PEGASUSRITTER > 1 && !pegasus) {
			setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
		} else {
			if(!set){
				VOLKBretonia.PEGASUSRITTER ++;
			}
			setFehlermeldung("");
			set = true;
		}
	}

	@Override
	public void deleteYourself() {
		VOLKBretonia.PEGASUSRITTER --;
		super.deleteYourself();
	}
}

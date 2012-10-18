package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SKBeutehaufen extends RuestkammerVater {

	OptionsUpgradeGruppe oBH;

	public SKBeutehaufen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		int bufferCnt= cnt, bufferCnt2 = cnt;
		cnt = randAbstand;
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinmuskete"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Giftattacken"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwanzwaffe"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpsteinpistole"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wachratte"), 5));
		
		add(oBH = new OptionsUpgradeGruppe(ID, randAbstand + 10, cnt+10, "", ogE));
		setHeadline(oBH, BuildaHQ.translate("Der Beutehaufen"));
		setUeberschrift(BuildaHQ.translate("Der Beutehaufen"));
		
		seperator();
		
		sizeSetzen(100, 100, 280, KAMMER_HOEHE + BuildaHQ.wasIstHoeher(bufferCnt, bufferCnt2, cnt));
	}

	@Override
	public void refreshen() {
	
	}

}

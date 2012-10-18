package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SKMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public SKMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Grey Seer
		// defaults[1] = Kriegsheer
		// defaults[0] = Seuchenpriester
		
		if(defaults[0])ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hˆllenglocke"), 200));
		if(defaults[1]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Knochenreiﬂer-Rattenoger"), 65));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kriegss‰nfte"), 35));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Groﬂe Pockenratte"), 30));
		}
		if(defaults[2]){
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Groﬂe Pockenratte"), 30));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seuchenmenetekel"), 150));
		}
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reitdinge"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
	}
}

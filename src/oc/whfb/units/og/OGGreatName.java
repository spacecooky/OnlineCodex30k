package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class OGGreatName extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean isTyrann = false;
	boolean isJaeger = false;

	@Override
	public void initButtons(boolean... defaults) {
		isTyrann = defaults[0];
		isJaeger = defaults[1];
		
		if (isTyrann) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlundpilger"), 40));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mauerbrecher"), 30));
		if (isTyrann) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sippenfresser"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bergfresser"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenbrecher"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Todpreller"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturml‰ufer"), 20));
		if (isJaeger) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bestienschl‰chter"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Rempelwanst"), 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Groﬂer Name"));
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		
	}
}

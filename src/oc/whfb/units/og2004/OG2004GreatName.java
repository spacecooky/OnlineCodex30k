package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class OG2004GreatName extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean isTyrann = false;
	boolean isBrecher = false;
	boolean isJaeger = false;

	@Override
	public void initButtons(boolean... defaults) {
		isTyrann = defaults[0];
		isJaeger = defaults[1];
		isBrecher = defaults[2];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bruderfresser"), BuildaHQ.translate("Groﬂer Name: Bruderfresser"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bergesser"), BuildaHQ.translate("Groﬂer Name: Bergesser"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturml‰ufer"), BuildaHQ.translate("Groﬂer Name: Sturml‰ufer"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenbrecher"), BuildaHQ.translate("Groﬂer Name: Riesenbrecher"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("‹berleber"), BuildaHQ.translate("Groﬂer Name: ‹berleber"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bestienschl‰chter"), BuildaHQ.translate("Groﬂer Name: Bestienschl‰chter"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mauerbrecher"), BuildaHQ.translate("Groﬂer Name: Mauerbrecher"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schlundpilger"), BuildaHQ.translate("Groﬂer Name: Schlundpilger"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Groﬂer Name"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setLegal(o1.isSelected());

		// Enable / disable Great Names
		o1.setAktiv(BuildaHQ.translate("Groﬂer Name: Riesenbrecher"), BuildaHQ.getCountFromInformationVector("OGSklavenriese") > 0);
		o1.setAktiv(BuildaHQ.translate("Groﬂer Name: Bruderfresser"), isTyrann);
		o1.setAktiv(BuildaHQ.translate("Groﬂer Name: Bestienschl‰chter"), isTyrann || isJaeger);
	}

}

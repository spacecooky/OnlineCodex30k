
package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class WEMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	int maxCosts = 0;
	boolean isWilderJaeger = false;
	boolean isZauberer = false;

	boolean isHighborn = false;
	boolean isNoble = false;
	boolean isSpellweaver = false;
	boolean isSpellsinger = false;

	public WEMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		isHighborn = defaults[0];
		isNoble = defaults[1];
		isSpellweaver = defaults[2];
		isSpellsinger = defaults[3];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Elfenross"), 18));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenhirsch"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenadler"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Einhorn"), 65));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Walddrache"), 320));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(BuildaHQ.translate("Riesenhirsch"), isWilderJaeger);
		o1.setAktiv(BuildaHQ.translate("Einhorn"), isZauberer);
		o1.setAktiv(BuildaHQ.translate("Walddrache"), isHighborn && !isWilderJaeger);
		o1.setAktiv(BuildaHQ.translate("Riesenadler"), !isWilderJaeger);
		if(isSpellsinger){
			o1.setAktiv(BuildaHQ.translate("Riesenadler"), false);
		}

		if(isNoble || isSpellsinger) {
			o1.setPreis(BuildaHQ.translate("Elfenross"), 12);
		}
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals(BuildaHQ.translate("Wilde Jäger-Sippe"))) {
			this.isWilderJaeger = aktiv;
		}
		if(name.equals(BuildaHQ.translate("Zauberer-Sippe"))) {
			this.isZauberer = aktiv;
		}
	}

}

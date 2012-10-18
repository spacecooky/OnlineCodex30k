package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class WEKindred extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	int maxCosts = 0;
	boolean keinZauberer = false;
	boolean Preis = false;

	public WEKindred() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		keinZauberer = defaults[0];
		Preis = defaults[1];

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampft�nzer-Sippe"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wilde J�ger-Sippe"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Waldl�ufer-Sippe"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wandler-Sippe"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kundschafter-Sippe"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ewigkeit-Sippe"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Wadlelfen Sippe"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setAktiv(BuildaHQ.translate("Kampft�nzer-Sippe"), keinZauberer);
		o1.setAktiv(BuildaHQ.translate("Wilde J�ger-Sippe"), keinZauberer);
		o1.setAktiv(BuildaHQ.translate("Waldl�ufer-Sippe"), keinZauberer);
		o1.setAktiv(BuildaHQ.translate("Wandler-Sippe"), keinZauberer);
		o1.setAktiv(BuildaHQ.translate("Kundschafter-Sippe"), keinZauberer);
		o1.setAktiv(BuildaHQ.translate("Ewigkeit-Sippe"), keinZauberer);

		if(Preis) {
			o1.setPreis(BuildaHQ.translate("Kampft�nzer-Sippe"), 30);
			o1.setPreis(BuildaHQ.translate("Wilde J�ger-Sippe"), 35);
			o1.setPreis(BuildaHQ.translate("Waldl�ufer-Sippe"), 35);
			o1.setPreis(BuildaHQ.translate("Wandler-Sippe"), 25);
			o1.setPreis(BuildaHQ.translate("Kundschafter-Sippe"), 15);
			o1.setPreis(BuildaHQ.translate("Ewigkeit-Sippe"), 5);
		}
	}

	@Override
	public Object getSpecialValue() {
		return (o1.getCurrentName());
	}
}

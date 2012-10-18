
package oc.wh40k.units.cm2007;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007Champion extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe og;

	boolean isSlaanesh = false;
	boolean isKhorne = false;
	boolean isBiker = false;
	boolean isRaptor = false;
	boolean isChild = false;

	public CM2007Champion() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try {
                    isSlaanesh = defaults[0];
                    isKhorne = defaults[1];
                    isBiker = defaults[2];
                    isRaptor = defaults[3];
                    isChild = defaults[4];
                } catch(Exception e) {}

		if(!isSlaanesh && !isKhorne && !isBiker && !isRaptor) {
                        if(isChild) ogE.addElement(new OptionsGruppeEintrag("Sonic Blaster", 5));
			ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
			ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
			add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

			seperator(5);
		}

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(og = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(5);

		if(isSlaanesh) {
			add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockbooster", 15));
			add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sonic Blaster", 5));
		} else {
			add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmapistole", 15));
                        if(isChild) add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockbooster", 10));
		}

		if(isRaptor) {
			add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energieklauenpaar", 25));
		}

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(isRaptor) {
			o1.setAktiv(!o2.isSelected());
			o2.setAktiv(!o1.isSelected());

			og.setAktiv(!o2.isSelected());
		}
	}

}

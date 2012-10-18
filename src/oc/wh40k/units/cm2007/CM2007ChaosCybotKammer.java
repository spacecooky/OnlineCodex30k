
package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class CM2007ChaosCybotKammer extends RuestkammerVater {

	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe oe1;
	OptionsUpgradeGruppe oe2;
	OptionsZaehlerGruppe oe3;
	OptionsZaehlerGruppe oe3b;

        boolean child;

	public CM2007ChaosCybotKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaos-Cybot\n";
            grundkosten = 90;

            try {
                child = defaults[0]; //Emperor's Children
            } catch(Exception e) {}

            add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));
            
            seperator(8);

            ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 10)); // name bei refreshen auch ändern
            ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));

            ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Bolter", "Synchronisierter Schwerer Bolter", 15));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Sync. Sonic Blaster", "Synchronisierter Sonic Blaster", 15));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 20));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Sync. Blastermaster", "Synchronisierte Blastmaster", 20));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
            add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 0));
            ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 0));
            add(oe2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("synchr. Bolter", "synchronisierter Bolter", 0));
            add(oe3b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            ogE.addElement(new OptionsGruppeEintrag("schwerer Flammenwerfer", 5));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Schockbooster", 5));
            add(oe3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dreadclaw [FW/IAA]", "Dreadclaw [Forgeworld/Imperial Armour Apocalypse]", 65));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            int cnkw = (oe1.isSelected("Cybot-Nahkampfwaffe") ? 1 : 0) + (oe2.isSelected("Cybot-Nahkampfwaffe") ? 1 : 0);
            oe3.setMaxAnzahl(cnkw > 0 ? 1 : 0);
            oe3b.setMaxAnzahl(cnkw);
            oe3b.setAnzahl(0, cnkw - oe3.getAnzahl());

            oe1.alwaysSelected();
            oe2.alwaysSelected();

	}

}

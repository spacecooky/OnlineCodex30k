package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007ChaosCybot extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe oe1;
	OptionsUpgradeGruppe oe2;

	public CM2007ChaosCybot() {
		name = "Chaos-Cybot";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));
		

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 10)); // name bei refreshen auch ändern
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 15));
		
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Bolter", "Synchronisierter Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 35));
		add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 0));
		add(oe2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schwerer Flammenwerfer", 5));
		
		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dreadclaw [FW/IAA]", "Dreadclaw [Forgeworld/Imperial Armour Apocalypse]", 65));
        
		complete();
	}

	@Override
	public void refreshen() {
		if(!oe1.isSelected()) oe1.setSelected(0, true);
		if(!oe2.isSelected()) oe2.setSelected(0, true);
		o1.setAktiv(oe1.isSelected("Cybot-Nahkampfwaffe") || oe2.isSelected("Cybot-Nahkampfwaffe"));
	}

}

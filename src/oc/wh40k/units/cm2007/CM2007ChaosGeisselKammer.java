
package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007ChaosGeisselKammer extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public CM2007ChaosGeisselKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaos-Geissel\n";
            grundkosten = 150;

            add(ico = new oc.Picture("oc/wh40k/images/ChaosDefiler.gif"));
            
            seperator();

            if(defaults[0]) add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfgeschütz", 0));

            seperator();

            add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kampfgeschütz", 0));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
            ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffenarm", 0));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 5));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", "Zwillingsmaschinenkanone", 0));
            ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffenarm", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisiewrte Laserkanone", 20));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3.setSelected(0, true);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            o1.setSelected(true);
            if(!o2.isSelected()) o2.setSelected(0, true);
            if(!o3.isSelected()) o3.setSelected(0, true);
	}

}

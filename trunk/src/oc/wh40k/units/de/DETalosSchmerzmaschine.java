package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DETalosSchmerzmaschine extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public DETalosSchmerzmaschine() {
		name = "Talos-Schmerzmaschine";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/DETalosSchmerzmaschine.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Säurewerfer", "Synchronisierter Säurewerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sekretinjektor", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kettenflegel", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Zusätzliche Nahkampfwaffe", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. Splitterkanone", "Synchronisierte Splitterkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schmerzprojektor", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Impulsblaster", "Synchronisierter Impulsblaster", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Hitzelanze", "Synchronisierte Hitzelanze", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) {
            o1.setSelected(0, true);
        }
        if(!o2.isSelected()) {
            o2.setSelected(0, true);
        }
	}

}

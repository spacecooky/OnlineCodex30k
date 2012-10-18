/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 */

package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKLandRaiderRedeemer extends Eintrag {
        OptionsUpgradeGruppe o2;

	public GKLandRaiderRedeemer() {
		name = "Land Raider Redeemer";
		grundkosten = 245;
                
		add(ico = new oc.Picture("oc/wh40k/images/GKLandRaiderRedeemer.jpg"));

                ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 0));
                ogE.addElement(new OptionsGruppeEintrag("[FW] Psycannon", "[Forgeworld] Deimos-Lux Pattern Psycannon", 20));
                add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktives Promethium", 15));

		complete();
	}

	@Override
	public void refreshen() {
            o2.alwaysSelected();
	}

}

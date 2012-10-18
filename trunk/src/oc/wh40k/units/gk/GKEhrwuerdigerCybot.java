/* Regeln für Deimos-Lux Pattern Psycannon unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 */

package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKEhrwuerdigerCybot extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsEinzelUpgrade promethium;

    public GKEhrwuerdigerCybot() {
            name = "Ehrwürdiger Cybot";
            grundkosten = 175;

            add(ico = new oc.Picture("oc/wh40k/images/GKEhrwuerdigerCybot.jpg"));
            

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Nemesis-Bannfaust", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 5));
            ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 5));
            add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flammenwerfer", 0));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
            ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
            ogE.addElement(new OptionsGruppeEintrag("[FW] Psycannon", "[Forgeworld] Deimos-Lux Pattern Psycannon", 20));
            ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 30));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktive Munition", 5));
            add(promethium = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psiaktives Promethium", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpstabilisierungsfeld", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wahrsilberpanzerung", 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

            complete();
    }

    @Override
    public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        if(!o2.isSelected()) o2.setSelected(0, true);
        if(!o3.isSelected()) o3.setSelected(0, true);

        o1.setAktiv(o3.isSelected("Nemesis-Bannfaust"));

        promethium.setAktiv(o1.isSelected("Schwerer Flammenwerfer") || o2.isSelected("Synchronisierter Schwerer Flammenwerfer"));
    }

}

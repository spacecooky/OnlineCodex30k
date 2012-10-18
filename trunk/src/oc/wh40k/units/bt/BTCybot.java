package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class BTCybot extends Eintrag {

    OptionsEinzelUpgrade honorable;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    RuestkammerStarter rkPod;

    boolean added = false;

    public BTCybot() {
        name = "Cybot";
        grundkosten = 105;

        add(ico = new oc.Picture("oc/wh40k/images/BTCybot.jpg"));
        

        seperator(12);

        add(honorable = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ehrwürdig", "Upgrade zum Ehrwürdigen Cybot", 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rasender Angriff", 10));
        ogE.addElement(new OptionsGruppeEintrag("Panzerjäger", 10));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Cybot-NKW", "Cybot-Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 20));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Zusätzliche Panzerung", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Suchscheinwerfer", 1));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Nebelwerfer", 3));

        seperator(8);

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BTDropPodKammer", "Landungskapsel");
		rkPod.initKammer(true);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

        honorable.setToolTipText("Nur ein Cybot pro Armee darf ein Ehrwürdiger Cybot sein.");

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }
        if (!o2.isSelected()) {
            o2.setSelected(0, true);
        }
        if (!o3.isSelected()) {
            o3.setSelected(0, true);
        }

        o2.setAktiv(o1.isSelected("Cybot-Nahkampfwaffe"));
        o4.setAktiv(honorable.isSelected());

        // Unique entry: Erwürdiger Cybot
        if (!added && honorable.isSelected()) {
            BuildaHQ.addToInformationVector("BTEhrwuerdigerCybot", 1);
            added = true;
            RefreshListener.fireRefresh();
        } else if (added && !honorable.isSelected()) {
            BuildaHQ.addToInformationVector("BTEhrwuerdigerCybot", -1);
            added = false;
            RefreshListener.fireRefresh();
        }

        honorable.setLegal(BuildaHQ.getCountFromInformationVector("BTEhrwuerdigerCybot") < 2);
   }

    @Override
    public void deleteYourself() {
        if (honorable.isSelected()) {
            BuildaHQ.setInformationVectorValue("BTEhrwuerdigerCybot", 0);
        }
        super.deleteYourself();
    }

}

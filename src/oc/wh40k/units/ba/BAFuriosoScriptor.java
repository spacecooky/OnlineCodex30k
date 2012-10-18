package oc.wh40k.units.ba;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BAFuriosoScriptor extends Eintrag {

    OptionsUpgradeGruppe psi;
    RuestkammerStarter rkPod;

    public BAFuriosoScriptor() {
        name = "Furioso-Scriptor";
        grundkosten = 175;

        add(ico = new oc.Picture("oc/wh40k/images/BAFuriosoScriptor.jpg"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Blutspeer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Macht der Helden", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schild des Sanguinius", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schmetterschlag", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwert des Sanguinius", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schrecken d. Finsternis", "Schrecken der Finsternis", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwingen d. Sanguinius", "Schwingen des Sanguinius", 0));
        ogE.addElement(new OptionsGruppeEintrag("Seelenfesseln", 0));
        ogE.addElement(new OptionsGruppeEintrag("Siedendes Blut", 0));
        ogE.addElement(new OptionsGruppeEintrag("Zorn entfesseln", 0));
        add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Landungskapsel");
        rkPod.initKammer(false, true, false, false);
        rkPod.setButtonText("Landungskapsel");
        rkPod.setSeperator(0);
        add(rkPod);

        complete();
    }

    @Override
    public void refreshen() {
        if (psi.getAnzahl() < 2) {
            psi.setLegal(false);
            setFehlermeldung("Wähle 2 Psikräfte");
        } else {
            psi.setLegal(true);
            setFehlermeldung("");
        }
    }
    
}

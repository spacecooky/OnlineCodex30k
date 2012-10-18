/* Experimentelle Regeln zu finden auf der Forgeworld-Website:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/r/Reaper.pdf
 */

package oc.wh40k.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DEReaper extends Eintrag {

    public DEReaper() {
        grundkosten = 135;

        add(ico = new oc.Picture("oc/wh40k/images/DESchattenbarke.jpg"));
        

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Schocksporn", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Terrorgas-Granatwerfer", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Bremstriebwerke", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Fangketten", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Grausige Trophäen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Toxinklingen", 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Nachtfeld", 10));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Flackerfeld", 10));

        complete();
    }


    @Override
    public void refreshen() {
    }

}

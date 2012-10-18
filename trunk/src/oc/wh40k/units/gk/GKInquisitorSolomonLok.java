/*Regeln unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/g/greyknightsupd.pdf
 */

package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;

public class GKInquisitorSolomonLok extends Eintrag {


    public GKInquisitorSolomonLok() {
        name = "Inquisitor Solomon Lok";
        grundkosten = 100;

        BuildaHQ.addToInformationVector("GKInquisitor", 1);

        add(ico = new oc.Picture("oc/wh40k/images/GKInquisitorHectorRex.jpg"));
        

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("GKInquisitor", -1);
        super.deleteYourself();
    }

}
/* experimentelle Regeln unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/p/phantom.pdf
 */

package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ELPhantomTitan extends Eintrag {

	OptionsZaehlerGruppe o3;
	OptionsUpgradeGruppe o1;

	public ELPhantomTitan() {
		name = "Phantom Titan";
		grundkosten = 2500;

		add(ico = new oc.Picture("oc/wh40k/images/ELPhantomTitan.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Titan Pulsar", "Phantom Titan Pulsar", 0));
		ogE.addElement(new OptionsGruppeEintrag("Distortion Cannon", "Phantom Titan Distortion Cannon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Titan CCW", "Titan close combat weapon + twin-linked Phantom Starcannons", 0));

		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Titan Starcannon", "Phantom Titan", 0));
		ogE.addElement(new OptionsGruppeEintrag("Pulse Laser", 0));
		o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(o1);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		o1.alwaysSelected();
                o3.setButtonMaxAnzahl("Titan close combat weapon + twin-linked Phantom Starcannons", 1);
                o3.setLegal(o3.getAnzahl() == 2);
	}

}

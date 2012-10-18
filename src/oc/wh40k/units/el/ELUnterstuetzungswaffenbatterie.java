package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ELUnterstuetzungswaffenbatterie extends Eintrag {

	AnzahlPanel Unterstuetzungswaffenbatterie;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter r�stkammer;

	public ELUnterstuetzungswaffenbatterie() {

		name = "Unterstuetzungswaffenbatterie";

		grundkosten = 0;

		Unterstuetzungswaffenbatterie = new AnzahlPanel(ID, randAbstand, cnt, "Unterst�tzungswaffe", "Unterst�tzungswaffen", 1, 3, 20);
		add(Unterstuetzungswaffenbatterie);
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/Unterstuetzungswaffenbatterie.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Monofilamentweber", 10));
		ogE.addElement(new OptionsGruppeEintrag("Infraschallkanone", 30));
		ogE.addElement(new OptionsGruppeEintrag("Warpkanone", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(15);

		r�stkammer = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser");
		r�stkammer.initKammer(false, false);
		add(r�stkammer);

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		o1.setModelle(Unterstuetzungswaffenbatterie.getModelle());
                o1.alwaysSelected();
	}
}

package oc.wh30k.units.lc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class LCTechthrallAdsecularis extends Eintrag {

	OptionsUpgradeGruppe o1, o2;

	public LCTechthrallAdsecularis() {
		name = "Tech-thrall Adsecularis\n";
		grundkosten = 35;
		überschriftSetzen = true;

		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Frag grenades", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rite of Pure Thought", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		ogE.addElement(new OptionsGruppeEintrag("Las-locks", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotguns", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy chainblades", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o2.isSelected()) {o2.setSelected(0, true);}
		
	}

}

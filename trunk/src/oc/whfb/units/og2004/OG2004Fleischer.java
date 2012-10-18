package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class OG2004Fleischer extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	
	public OG2004Fleischer() {
		name = BuildaHQ.translate("Fleischer");
		grundkosten = 130;

		add(ico = new oc.Picture("oc/images/OGFleischer.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zahngnoblar"), 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Glücksgnoblar"), 5));

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004MagicItems", "");
		rkMagic.initKammer(false, false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}

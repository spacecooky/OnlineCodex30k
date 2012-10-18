package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class OG2004Fleischermeister extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public OG2004Fleischermeister() {
		name = BuildaHQ.translate("Fleischermeister");
		grundkosten = 200;

		add(ico = new oc.Picture("oc/images/OGFleischermeister.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zahngnoblar"), 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 3));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Glücksgnoblar"), 5));

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004MagicItems", "");
		rkMagic.initKammer(false, true, false, false);
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
		
		// Unique entry: GENERAL
		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
		if(genGlobal && !genSelected) oGen.setAktiv(false);
		else oGen.setAktiv(true);

		if(oGen.isSelected()) {
			genSelected = true;
			BuildaHQ.setInformationVectorValue("Gen", 1);
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}

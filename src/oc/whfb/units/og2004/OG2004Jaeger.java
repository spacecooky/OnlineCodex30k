package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class OG2004Jaeger extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkName;
	RuestkammerStarter rkMagic;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public OG2004Jaeger() {
		name = BuildaHQ.translate("Jäger");
		grundkosten = 145;

		BuildaHQ.addToInformationVector("OGJaeger", 1);

		add(ico = new oc.Picture("oc/images/OGJaeger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Säbelzahntiger"), 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		rkName = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004GreatName", "");
		rkName.initKammer(false, true, false);
		rkName.setButtonText(BuildaHQ.translate("Großer Name"));
		add(rkName);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004MagicItems", "");
		rkMagic.initKammer(false, false, false, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		if(rkMagic.getKosten() + rkName.getKosten() > 50) {
			setFehlermeldung(BuildaHQ.translate("Magie + Name") + " > 50!");
		} else {
			setFehlermeldung("");
		}
		
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
		BuildaHQ.addToInformationVector("OGJaeger", -1);
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}

}

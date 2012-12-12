package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DGLegionThunderhawkTransporter extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;

	public DGLegionThunderhawkTransporter() {
		name = "Legion Thunderhawk Transporter";
		grundkosten = 455;
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Hellstrike missile", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Chaff launcher", 10));
		ogE.addElement(new OptionsGruppeEintrag("Armoured cockpit", 15));
		ogE.addElement(new OptionsGruppeEintrag("Flare shield", 50));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
				
		complete();
	}

	@Override
	public void refreshen() {
				
	}

}

package oc.whfb.units.ck;

import java.util.Vector;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CKMagicLores extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe oTzeentch;
	OptionsUpgradeGruppe oNurgle;
	OptionsUpgradeGruppe oSlaanesh;
	
	boolean isTzeentch = false;
	boolean isNurgle = false;
	boolean isSlaanesh = false;
	
	boolean isMaster = false;
	
	public CKMagicLores() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {	
		
		try{
			isMaster = defaults[1];
		} catch (Exception e) { /* Ignore */ }
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Todes")));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Feuers")));
		if ( isMaster || !defaults[0]) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre der Schatten")));
		if ( isMaster ) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Himmels")));
		
		add(o1 = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		cnt = randAbstand;
		
		seperator(110);
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Tzeentch")));
		add(oTzeentch = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		seperator(1);
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Nurgle")));	
		add(oNurgle = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));
		
		seperator(1);
		
		ogE = new Vector<OptionsGruppeEintrag>();
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lehre des Slaanesh")));
		add(oSlaanesh = new OptionsUpgradeGruppe( ID, randAbstand, cnt, "", ogE, false ));

		
		setHeadline(o1, BuildaHQ.translate("Lehren der Magie"));
		setUeberschrift(BuildaHQ.translate("Lehren der Magie"));
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		if( isTzeentch ) {
			oTzeentch.setAktiv(true);
			oTzeentch.alwaysSelected();			
			o1.setAktiv(false);
			oNurgle.setAktiv(false);
			oSlaanesh.setAktiv(false);
		} else if( isNurgle ) {
			oNurgle.setAktiv(true);
			oNurgle.alwaysSelected();
			o1.setAktiv(false);
			oTzeentch.setAktiv(false);
			oSlaanesh.setAktiv(false);
		} else if( isSlaanesh ) {
			oSlaanesh.setAktiv(true);
			oSlaanesh.alwaysSelected();
			o1.setAktiv(false);
			oTzeentch.setAktiv(false);
			oNurgle.setAktiv(false);
		} else {
			o1.setAktiv(true);
			o1.alwaysSelected();
			oTzeentch.setAktiv(false);
			oNurgle.setAktiv(false);
			oSlaanesh.setAktiv(false);
		}
	}
	
	@Override
	public void specialAction(boolean... action) {
		isTzeentch = action[0];
		isNurgle = action[1];
		isSlaanesh = action[2];
		
		refreshen();
	}
}

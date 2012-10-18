package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsGruppeEintrag oe;

	boolean isLord = false;
	boolean isMage = false;

	boolean isOrc = false;
	boolean isGoblin = false;
	boolean isNightGoblin = false;
	boolean isWildork = false;
	
	OptionsEinzelUpgrade addO;
	OptionsEinzelUpgrade addG;
	OptionsEinzelUpgrade addW;
	OptionsEinzelUpgrade addSchrein;
	
	boolean isChariot = false;

	public ORMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Lord / Hero
		// defaults[1] = Mage / not Mage
		// defaults[2] = Orc
		// defaults[3] = Goblin
		// defaults[3] = Night Goblin

		isLord = defaults[0];
		isMage = defaults[1];

		isOrc = defaults[2];
		isGoblin = defaults[3];
		isNightGoblin = defaults[4];

		if(isOrc) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wildschwein"), isLord ? 24 : 16));
			if(!(!isLord && isMage)) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wildschwein-Streitwagen"), 85));
			if(isLord) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lindwurm"), 160));
		
		} else if(isGoblin  || isNightGoblin) {
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenwolf"), isLord ? 18 : 12));
			if(!isMage)ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Riesenspinne"), isLord ? 22 : 15));
			ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Wolfsstreitwagen"), 50));
			if(!isMage) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Gigantula"), isLord ? 50 : 40));
			if(!isMage) ogE.addElement(oe = new OptionsGruppeEintrag(BuildaHQ.translate("Großer Höhlensquig"), isLord ? 40 : 50));	
		
			if( isMage && isLord ){
				ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Arachnarok-Spinne"), 290));
			}
		} 
		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
		
		if(isOrc) {
			if(!(!isLord && isMage)) {
				seperator();
				add(addO = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zusätzlicher Ork"), 5));
				addO.setAktiv(false);
			}
		} else if(isGoblin || isNightGoblin) {
			seperator();
			add(addG = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zusätzlicher Goblin"), 5));
			add(addW = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Zusätzlicher Riesenwolf"), 5));						
			addG.setAktiv(false);
			addW.setAktiv(false);
			
			if( isMage && isLord ){
				add(addSchrein = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Spinn'netzschrein"), 40));
				addSchrein.setAktiv(false);
			}
		}

		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		if(o1.isSelected(BuildaHQ.translate("Wolfsstreitwagen")) || o1.isSelected(BuildaHQ.translate("Wildschwein-Streitwagen"))){
			if(!isChariot){
				isChariot = true;				
				selectChariotOptions(isChariot);
			}			
		}else{
			if(isChariot){
				isChariot = false;
				selectChariotOptions(isChariot);				
			}
		}	
		
		if(o1.isSelected(BuildaHQ.translate("Arachnarok-Spinne"))){
			addSchrein.setAktiv(true);		
		}else{
			if(isLord && isMage && isGoblin)addSchrein.setAktiv(false);
		}	
		
		if ( isWildork ){
			o1.setAktiv(BuildaHQ.translate("Wildschwein-Streitwagen"), false);			
		} else if (isOrc && !(!isLord && isMage)){
			o1.setAktiv(BuildaHQ.translate("Wildschwein-Streitwagen"), true);		
		}
		
		if (isGoblin  && isNightGoblin && !isMage) {
			o1.setAktiv(BuildaHQ.translate("Riesenwolf"), false);
			o1.setAktiv(BuildaHQ.translate("Riesenspinne"), false);
			o1.setAktiv(BuildaHQ.translate("Wolfsstreitwagen"), false);
			o1.setAktiv(BuildaHQ.translate("Gigantula"), false);			
			o1.setAktiv(BuildaHQ.translate("Großer Höhlensquig"), true);					
		} else if (isGoblin  && !isNightGoblin && !isMage) {
			o1.setAktiv(BuildaHQ.translate("Riesenwolf"), true);
			o1.setAktiv(BuildaHQ.translate("Riesenspinne"), true);
			o1.setAktiv(BuildaHQ.translate("Wolfsstreitwagen"), true);
			if(!isMage)o1.setAktiv(BuildaHQ.translate("Gigantula"), true);			
			if(!isMage)o1.setAktiv(BuildaHQ.translate("Großer Höhlensquig"), false);
		}
	}

	@Override
	public void specialAction(boolean... action) {
		isNightGoblin = action[0];
		o1.setAktiv(BuildaHQ.translate("Großer Höhlensquig"), action[0]);

		if(isMage) {
			o1.setAktiv(BuildaHQ.translate("Riesenwolf"), !isNightGoblin);
			o1.setAktiv(BuildaHQ.translate("Wolfsstreitwagen"), !isNightGoblin);
		}
		
		try { isWildork = action[1]; }catch (Exception e) { isWildork = false; }
	}
	
	public void selectChariotOptions(boolean isChariot){
		if(isOrc) {
			if(!(!isLord && isMage)) {
				addO.setAktiv(isChariot);
			}
		} else if(isGoblin || isNightGoblin) {
			addG.setAktiv(isChariot);
			addW.setAktiv(isChariot);			
		}
	}
}

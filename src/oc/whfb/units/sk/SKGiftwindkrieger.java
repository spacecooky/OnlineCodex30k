package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.whfb.armies.VOLKSkaven;

public class SKGiftwindkrieger extends Eintrag {

	AnzahlPanel squad;

	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe1;
	
	boolean set= false;
	boolean weapon = false;
	
	public SKGiftwindkrieger() {
		name = BuildaHQ.translate("Giftwindkrieger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Giftwindkrieger"), 5, 15, 10);		
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 5));
		add(oe2= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Todeswindkugel"), 25));
		oe2.setAktiv(false);
		
		seperator();
		
		add(oe3= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftwindmörser"), 65));
		
		complete();
	}

	@Override
	public void refreshen(){
		oe2.setAktiv(oe1.isSelected());
		
		if(!set)VOLKSkaven.GLOBARDIERS ++;						
		set = true;
		
		if(oe3.getKosten() > 0){
			if(!weapon){
				VOLKSkaven.GLOBARDIERSWT ++;
			}
			weapon = true;
		}else{
			if(weapon){
				weapon = false;
				VOLKSkaven.GLOBARDIERSWT --;
			}
		}
						
		double d = (Double.valueOf(VOLKSkaven.GLOBARDIERS).doubleValue()/2) + 0.5;
		int i = (int)d;		

		if(VOLKSkaven.GLOBARDIERSWT > i){
			setFehlermeldung(BuildaHQ.translate("Waffenteams")+": 0-"+i);
		}else{
			try {
				setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
			} catch (Exception e){
				setUnikat(true, 3);
			}							
		}		
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		VOLKSkaven.GLOBARDIERS --;
		if(weapon){
			VOLKSkaven.GLOBARDIERSWT --;
		}
		super.deleteYourself();
	}

}

import { useWeb3React } from '@web3-react/core';
import { Contract, ethers, Signer } from 'ethers';
import {
  ChangeEvent,
  MouseEvent,
  ReactElement,
  useEffect,
  useState
} from 'react';
import styled from 'styled-components';
import GreeterArtifact from '../artifacts/contracts/Greeter.sol/Greeter.json';
import DutchArtifact from '../artifacts/contracts/DutchAuction.sol/DutchAuction.json';
import { Provider } from '../utils/provider';
import { SectionDivider } from './SectionDivider';
import { Web3Provider } from '@ethersproject/providers';

const StyledDeployContractButton = styled.button`
  width: 180px;
  height: 2rem;
  border-radius: 1rem;
  border-color: blue;
  cursor: pointer;
  place-self: center;
`;

const StyledGreetingDiv = styled.div`
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-columns: 135px 2.7fr 1fr;
  grid-gap: 10px;
  place-self: center;
  align-items: center;
`;

const StyledLabel = styled.label`
  font-weight: bold;
`;

const StyledInput = styled.input`
  padding: 0.4rem 0.6rem;
  line-height: 2fr;
`;

const StyledButton = styled.button`
  width: 150px;
  height: 2rem;
  border-radius: 1rem;
  border-color: blue;
  cursor: pointer;
`;

export function Greeter(): ReactElement {
  const context = useWeb3React<Provider>();
  const { library, active,account } = context;
  
  const [signer, setSigner] = useState<Signer>();
  const [greeterContract, setGreeterContract] = useState<Contract>();
  const [greeterContractAddr, setGreeterContractAddr] = useState<string>('');
  const [ownerAddr, setOwnerAddr] = useState<string>();
  const [greeting, setGreeting] = useState<string>('');
  const [greetingInput, setGreetingInput] = useState<string>('');


  const [auctionContract, setAuctionContract] = useState<Contract>();
  const [reservePriceInput, setReservePriceInput] = useState<string>('');
  const [blocksInput, setBlocksInput] = useState<string>('');
  const [decrementInput, setDecrementInput] = useState<string>('');
  const [winnderAddress, setWinnderAddress] = useState<string>('');
  var [judgeInput, setJudgeInput] = useState<string>('');

  //AWAITING_PAYMENT, AWAITING_DELIVERY, COMPLETE

  const [AWAITING_PAYMENT,setPayment] = useState(false)
  const [AWAITING_DELIVERY,setDelivery] = useState(false)
  const [COMPLETE,setComplete] = useState(false)


  useEffect((): void => {
    if (!library) {
      setSigner(undefined);
      return;
    }

    setSigner(library.getSigner());
  }, [library]);

  useEffect((): void => {
    if (!greeterContract) {
      return;
    }

    async function getGreeting(greeterContract: Contract): Promise<void> {
      const _greeting = await greeterContract.greet();

      if (_greeting !== greeting) {
        setGreeting(_greeting);
      }
    }

    getGreeting(greeterContract);
  }, [greeterContract, greeting]);

  function handleDeployContract(event: MouseEvent<HTMLButtonElement>) {
    event.preventDefault();

    // only deploy the Greeter contract one time, when a signer is defined
    if (greeterContract || !signer) {
      return;
    }


    async function deployAuctionContract(signer: Signer): Promise<void> {
      const Auction = new ethers.ContractFactory(
        DutchArtifact.abi,
        DutchArtifact.bytecode,
        signer
      );

      try {

        if(!judgeInput){
          judgeInput = '0x0000000000000000000000000000000000000000';
        }

        const reservePrice = ethers.utils.parseEther(reservePriceInput);
        const decrement = ethers.utils.parseEther(decrementInput);
        const auctionContract = await Auction.deploy(reservePrice,judgeInput,parseInt(blocksInput),decrement);

        await auctionContract.deployed();


        setAuctionContract(auctionContract);
        
        window.alert(`Auction deployed to: ${auctionContract.address}`);
        var owner = ''
        if(account){
          owner = account;
        }
        setOwnerAddr(owner);
        setGreeterContractAddr(auctionContract.address);
        setPayment(true);
      } catch (error: any) {
        window.alert(
          'Error!' + (error && error.message ? `\n\n${error.message}` : '')
        );
      }
    }
    deployAuctionContract(signer);
    //deployGreeterContract(signer);
  }

  function handleBidChange(event: ChangeEvent<HTMLInputElement>): void {
    event.preventDefault();
    setGreetingInput(event.target.value);
  }
  function handleReserveChange(event: ChangeEvent<HTMLInputElement>): void {
    event.preventDefault();
    setReservePriceInput(event.target.value);
  }
  function handleBlockChange(event: ChangeEvent<HTMLInputElement>): void {
    event.preventDefault();
    setBlocksInput(event.target.value);
  }
  function handleDecrementChange(event: ChangeEvent<HTMLInputElement>): void {
    event.preventDefault();
    setDecrementInput(event.target.value);
  }
  function handleJudgeChange(event: ChangeEvent<HTMLInputElement>): void {
    event.preventDefault();
    setJudgeInput(event.target.value);
  }

  function handleBidSubmit(event: MouseEvent<HTMLButtonElement>): void {
    event.preventDefault();

    if(!greetingInput){
      window.alert('Please enter amount');
      return;
    }
    if (!auctionContract) {
      window.alert('Undefined Auction Contract');
      return;
    }

    if (account === ownerAddr) {
      window.alert('Owner can not bid!');
      return;
    }

    async function submitBid(auctionContract: Contract): Promise<void> {
      try {
        if(!account){
          return
        }
        const bidAmount = ethers.utils.parseEther(greetingInput);
        const winner = await auctionContract.bid({ value: bidAmount});
        if(!winner){
          return
        }
        setPayment(false)
        if(!judgeInput){
          window.alert(`Success!\n\nWinner is : ${account}`);
          setComplete(true)
        }else{
          window.alert(`Success!\n\nWinner is : ${account}\n\nFurther action needed to complete the auction`);
          setDelivery(true)
        }
        setWinnderAddress(account)
        //window.alert(`Success!\n\nWinnder is : ${account}`);
      } catch (error: any) {
        window.alert(
          'Error!' + (error && error.message ? `\n\n${error.data.message}` : '')
        );
      }
    }

    submitBid(auctionContract);
  }

  function handleFinalize(event: MouseEvent<HTMLButtonElement>): void {
    event.preventDefault();

    if (!auctionContract) {
      window.alert('Undefined Auction Contract');
      return;
    }
    if(COMPLETE){
      window.alert('Auction is Complete');
      return;
    }

    if (account !== judgeInput && account !== winnderAddress) {
      window.alert('Only Judge or winner can finalize');
      return;
    }

    async function finalize(auctionContract: Contract): Promise<void> {
      try {
        await auctionContract.finalize();
        setDelivery(false)
        setWinnderAddress(winnderAddress + ' (Finalized)')
        setComplete(true)
        window.alert(`Finalized!\n\nWinnder is : ${winnderAddress}`);
      } catch (error: any) {
        window.alert(
          'Error!' + (error && error.message ? `\n\n${error.message}` : '')
        );
      }
    }

    finalize(auctionContract);
  }

  function handleRefund(event: MouseEvent<HTMLButtonElement>): void {
    event.preventDefault();

    if (!auctionContract) {
      window.alert('Undefined Auction Contract');
      return;
    }
    if(COMPLETE){
      window.alert('Auction is Complete');
      return;
    }

    if (account !== judgeInput) {
      window.alert('Only Judge can refund');
      return;
    }

    async function refund(auctionContract: Contract): Promise<void> {
      try {
        await auctionContract.refund(0);
        setDelivery(false)
        setWinnderAddress(winnderAddress + ' (Refunded)')
        setComplete(true)
        window.alert(`Refund!\n\nETH has been refunded to : ${winnderAddress}`);
      } catch (error: any) {
        window.alert(
          'Error!' + (error && error.message ? `\n\n${error.message}` : '')
        );
      }
    }

    refund(auctionContract);
  }

  return (
    <>
      <StyledGreetingDiv>
      <StyledLabel>Reserve Price</StyledLabel>
      <StyledInput
          disabled={!active || auctionContract ? true : false}
          id="reservePriceInput"
          type="text"
          onChange={handleReserveChange}
      ></StyledInput>
      <div></div>
      <StyledLabel>Number Of Blocks Open</StyledLabel>
      <StyledInput
          disabled={!active || auctionContract ? true : false}
          id="reservePriceInput"
          type="text"
          onChange={handleBlockChange}
      ></StyledInput>
      <div></div>
      <StyledLabel>Off Price Decrement</StyledLabel>
      <StyledInput
          disabled={!active || auctionContract ? true : false}
          id="reservePriceInput"
          type="text"
          onChange={handleDecrementChange}
      ></StyledInput>
      <div></div>
      <StyledLabel>judge</StyledLabel>
      <StyledInput
          disabled={!active || auctionContract ? true : false}
          id="reservePriceInput"
          type="text"
          onChange={handleJudgeChange}
      ></StyledInput>
      <div></div>
      </StyledGreetingDiv>
      <StyledDeployContractButton
        disabled={!active || auctionContract ? true : false}
        style={{
          cursor: !active || auctionContract ? 'not-allowed' : 'pointer',
          borderColor: !active || auctionContract ? 'unset' : 'blue'
        }}
        onClick={handleDeployContract}
      >
        Deploy Greeter Contract
      </StyledDeployContractButton>
      
      <SectionDivider />
      <StyledGreetingDiv>
        <StyledLabel>Contract addr</StyledLabel>
        <div>
          {greeterContractAddr ? (
            greeterContractAddr
          ) : (
            <em>{`<Contract not yet deployed>`}</em>
          )}
        </div>
        {/* empty placeholder div below to provide empty first row, 3rd col div for a 2x3 grid */}
        <div></div>
        <StyledLabel>Contract owner</StyledLabel>
        <div>
          {ownerAddr ? (
            ownerAddr
          ) : (
            <em>{`<Contract not yet deployed>`}</em>
          )}
        </div>
        {/* empty placeholder div below to provide empty first row, 3rd col div for a 2x3 grid */}
        <div></div>
        <StyledLabel>Contract reserve price</StyledLabel>
        <div>
          {reservePriceInput ? reservePriceInput : <em>{`<Contract not yet deployed>`}</em>}
        </div>
        {/* empty placeholder div below to provide empty first row, 3rd col div for a 2x3 grid */}
        <div></div>
        <StyledLabel>judge</StyledLabel>
        <div>
          {judgeInput ? judgeInput : <em>{`<No judge>`}</em>}
        </div>
        
        {/* empty placeholder div below to provide empty first row, 3rd col div for a 2x3 grid */}
        <div></div>
        <StyledLabel>winner</StyledLabel>
        <div>
          {winnderAddress ? winnderAddress : <em>{`<No Winner yet>`}</em>}
        </div>
        {/* empty placeholder div below to provide empty first row, 3rd col div for a 2x3 grid */}
        <div></div>
        <StyledLabel htmlFor="greetingInput">Enter bid amount</StyledLabel>
        <StyledInput
          disabled={!AWAITING_PAYMENT}
          id="greetingInput"
          type="text"
          onChange={handleBidChange}
          style={{ fontStyle: greeting ? 'normal' : 'italic' }}
        ></StyledInput>
        <StyledButton
          disabled={!AWAITING_PAYMENT}
          style={{
            cursor: AWAITING_PAYMENT ? 'pointer' : 'not-allowed',
            borderColor: !active || !auctionContract ? 'unset' : 'blue'
          }}
          onClick={handleBidSubmit}
        >
          Bid
        </StyledButton>
        <div></div>
        <div>
        <StyledButton
          disabled={!AWAITING_DELIVERY}
          style={{
            cursor: AWAITING_DELIVERY ? 'pointer' : 'not-allowed',
            borderColor: !active || !auctionContract ? 'unset' : 'grey'
          }}
          onClick={handleFinalize}
        >
          Finalize
        </StyledButton>
        <StyledButton
          disabled={!AWAITING_DELIVERY}
          style={{
            cursor: AWAITING_DELIVERY ? 'pointer' : 'not-allowed',
            borderColor: !active || !auctionContract ? 'unset' : 'grey'
          }}
          onClick={handleRefund}
        >
          Refund
        </StyledButton>
        </div>
      </StyledGreetingDiv>
    </>
  );
}
